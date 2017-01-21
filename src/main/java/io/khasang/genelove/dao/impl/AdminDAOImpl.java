package io.khasang.genelove.dao.impl;

import io.khasang.genelove.entity.AuthorisationKey;
import io.khasang.genelove.entity.Role;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.entity.Authorisation;
import io.khasang.genelove.dao.AdminDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AdminDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long getAllUsersCount() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(criteriaBuilder.count(root));
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<User> getUsers() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
        TypedQuery<User> typedQuery = sessionFactory.getCurrentSession().createQuery(criteriaQuery);
//        typedQuery.setFirstResult(firstRow);
//        typedQuery.setMaxResults(pageSize);
        return typedQuery.getResultList();
    }

    @Override
    public int getRoleId(String roleName) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<Role> root = criteriaQuery.from(Role.class);
        criteriaQuery.select(root.get("id"));
        criteriaQuery.where(criteriaBuilder.equal(root.get("roleName"),roleName));
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public boolean checkUserRole(User user, Role role) {
        AuthorisationKey key = new AuthorisationKey();
        key.setUserId(user.getId());
        key.setRoleId(role.getId());

        Authorisation authorisation = new Authorisation();
        authorisation.setAuthorisationKey(key);

        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<AuthorisationKey> criteriaQuery = criteriaBuilder.createQuery(AuthorisationKey.class);
        Root<Authorisation> root = criteriaQuery.from(Authorisation.class);
        criteriaQuery.select(root.get("authorisationKey"));
        criteriaQuery.where(criteriaBuilder.equal(root.get("authorisationKey"),authorisation.getAuthorisationKey()));

        try {
            sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
            return true;
        }
        catch (NoResultException nre) {
            return false;
        }
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        session.flush();
    }

    @Override
    public void addRole(User user, Role role) {
        AuthorisationKey key = new AuthorisationKey();
        key.setUserId(user.getId());
        key.setRoleId(role.getId());

        Authorisation authorisation = new Authorisation();
        authorisation.setAuthorisationKey(key);

        sessionFactory.getCurrentSession().save(authorisation);
    }

    @Override
    public void removeRole(User user, Role role) {
        AuthorisationKey key = new AuthorisationKey();
        key.setUserId(user.getId());
        key.setRoleId(role.getId());

        Authorisation authorisation = new Authorisation();
        authorisation.setAuthorisationKey(key);

        sessionFactory.getCurrentSession().delete(authorisation);
    }

    @Override
    public User getUserById(int id) {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        cq.select(root).where(cb.equal(root.get("id"), p));

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(cq);
        query.setParameter(p, id);
        return query.getSingleResult();
    }

    @Override
    public User getUserByLogin(String login) {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        cq.select(root).where(cb.equal(root.get("login"), p));

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(cq);
        query.setParameter(p, login);
        return query.getSingleResult();
    }

    @Override
    public Role getRoleById(int id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        cq.select(root).where(cb.equal(root.get("id"), p));

        TypedQuery<Role> query = session.createQuery(cq);
        query.setParameter(p, id);
        return query.getSingleResult();
    }

    @Override
    public Role getRoleByName(Role.RoleName name) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        ParameterExpression<Role.RoleName> p = cb.parameter(Role.RoleName.class);
        cq.select(root).where(cb.equal(root.get("roleName"), p));

        TypedQuery<Role> query = session.createQuery(cq);
        query.setParameter(p, name);
        return query.getSingleResult();
    }

    @Override
    public List<Role> getRoles() {
        Session session= sessionFactory.getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
        Root<Role> root = criteriaQuery.from(Role.class);
        criteriaQuery.select(root);

        TypedQuery<Role> typedQuery = session.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
