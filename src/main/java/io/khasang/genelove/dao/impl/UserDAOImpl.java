package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.UserDAO;
import io.khasang.genelove.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;
    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        User wasteUser = session.get(User.class, user.getId());
        session.delete(wasteUser);
    }

    @Override
    public void editUser (User user) {
    }

    @Override
    public List<User> getUserAll () {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(cq);
        return query.getResultList();
    }

    @Override
    public User getUserById (int id) {
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
    public User getUserByLogin (String login) {
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
    public void addAuthorisation(User user, Role role) {
        AuthorisationKey key = new AuthorisationKey();
        key.setUserId(user.getId());
        key.setRoleId(role.getId());
        Authorisation authorisation = new Authorisation();
        authorisation.setAuthorisationKey(key);
        sessionFactory.getCurrentSession().save(authorisation);

    }


    @Override
    public Role getRoleById (int id) {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        cq.select(root).where(cb.equal(root.get("id"), p));
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery(cq);
        query.setParameter(p, id);
        return query.getSingleResult();
    }

    @Override
    public Role getRoleByName (String name) {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> root = cq.from(Role.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        cq.select(root).where(cb.equal(root.get("role_name"), p));
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery(cq);
        query.setParameter(p, name);
        return query.getSingleResult();
    }

    @Override
    public void addFavourite(User user, Favourite favourite) {
        FavouriteKey key = new FavouriteKey();
        key.setUserId(user.getId());
        favourite.setFavouriteKey(key);
        sessionFactory.getCurrentSession().save(favourite);
    }

    public void deleteFavourite(User user, Favourite favourite){

    }

}