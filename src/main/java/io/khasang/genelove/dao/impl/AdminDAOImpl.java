package io.khasang.genelove.dao.impl;

import io.khasang.genelove.entity.AuthorisationKey;
import io.khasang.genelove.entity.Role;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.entity.Authorisation;
import io.khasang.genelove.dao.AdminDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());
        return (long)criteria.uniqueResult();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> getUsersList() {
//        Criteria criteria = sessionFactory.
//                getCurrentSession().
//                createCriteria(User.class);
//        return (List<User>) criteria.list();
//    }

    @Override
    public List<User> getUsers() {

        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(cq);
        return query.getResultList();
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

        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Authorisation> cq = cb.createQuery(Authorisation.class);
        Root<Authorisation> root = cq.from(Authorisation.class);
        ParameterExpression<Integer> userId = cb.parameter(Integer.class);
        ParameterExpression<Integer> roleId = cb.parameter(Integer.class);
        cq.select(root).where(cb.and(cb.equal(root.get("user_id"), userId), cb.equal(root.get("role_id"), roleId)));

        TypedQuery<Authorisation> query = session.createQuery(cq);
        query.setParameter(userId, user.getId());
        query.setParameter(roleId, role.getId());
        Authorisation authorisation = query.getSingleResult();

        session.delete(authorisation);
        session.flush();
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
}
