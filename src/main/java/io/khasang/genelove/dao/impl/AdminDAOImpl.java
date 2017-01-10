package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.AdminDAO;
import io.khasang.genelove.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsersList() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(User.class);
        return (List<User>) criteria.list();
    }
}
