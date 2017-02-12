package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.UserDAO;
import io.khasang.genelove.dao.AdminDAO;
import io.khasang.genelove.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
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

    @Autowired
    AdminDAO adminDAO;

    @Override
    public void addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        this.sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(user);
        session.flush();
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
    public User getUserById (long id) {
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
        Role role = adminDAO.getRoleByName(Role.RoleName.ROLE_USER);
        if (role != null) {
            Authorisation authorisation = new Authorisation(new AuthorisationKey(user, role));
            sessionFactory.getCurrentSession().save(authorisation);
        }
    }

    @Override
    public Role getRoleById (long id) {
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
    public List<Favourite> getFavouritesForUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Favourite> criteriaQuery = criteriaBuilder.createQuery(Favourite.class);

        Root<Favourite> root = criteriaQuery.from(Favourite.class);

        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("favouriteKey").get("user"), user));

        TypedQuery<Favourite> typedQuery = session.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public void addToFavourites(User currentUser, User favouriteUser) {
        Favourite favourite = new Favourite(currentUser, favouriteUser);
        sessionFactory.getCurrentSession().save(favourite);
    }

    @Override
    public void removeFromFavourites(User currentUser, User favouriteUser) {
        Session session = sessionFactory.getCurrentSession();
        Favourite favourite = new Favourite(currentUser, favouriteUser);
        session.delete(favourite);
        session.flush();
    }

    @Override
    public void update() {
        Query query = sessionFactory.getCurrentSession()
                .createNativeQuery("UPDATE users " +
                                      "SET receive_notifications = true " +
                                      "WHERE receive_notifications IS NULL");
        query.executeUpdate();
    }
}
