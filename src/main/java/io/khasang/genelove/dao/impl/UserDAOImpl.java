package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.UserDAO;
import io.khasang.genelove.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
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
        TypedQuery<User> query = sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM users", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById (int id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createNativeQuery("" +
                "SELECT * FROM users WHERE id = ?", User.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public User getUserByLogin (String login) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createNativeQuery("" +
                "SELECT * FROM users WHERE login = ?", User.class);
        query.setParameter(1, login);
        return query.getSingleResult();
    }

    @Override
    public void addAuthorisation(User user) {
        AuthorisationKey key = new AuthorisationKey();
        key.setUserId(user.getId());
        Role role = this.getRoleByName("ROLE_USER");
        key.setRoleId(role.getId());
        Authorisation authorisation = new Authorisation();
        authorisation.setAuthorisationKey(key);
        sessionFactory.getCurrentSession().save(authorisation);
    }


    @Override
    public Role getRoleById (int id) {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createNativeQuery("" +
                "SELECT * FROM roles WHERE id = ?", Role.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public Role getRoleByName (String name) {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createNativeQuery("" +
                "SELECT * FROM roles WHERE role_name = ?", Role.class);
        query.setParameter(1, name);
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
