package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.UsersDao;
import io.khasang.genelove.entity.Credentials;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UsersDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(Credentials credentials) {
        sessionFactory.getCurrentSession().save(credentials);
    }

    @Override
    public void updateUser(Credentials credentials) {
    /*    final String query = "SELECT users from users WHERE id=:id";
        String oldUser = (String) sessionFactory.getCurrentSession()
                .createQuery("SELECT users from users WHERE id=:id")
                .setParameter("id", users.getId())
                .uniqueResult();
        users.setFirstName(oldUser);
        sessionFactory.getCurrentSession().update(users);*/
    }

    @Override
    public void deleteUser(Credentials credentials) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(credentials);
        session.flush();
    }

    @Override
    public Credentials getUserById(int id) {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(Credentials.class);
        criteria.add(Restrictions.eq("id", id));
        return (Credentials) criteria.uniqueResult();
    }

    @Override
    public List<Credentials> getUsers() {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(Credentials.class);
        return criteria.list();
    }
}
