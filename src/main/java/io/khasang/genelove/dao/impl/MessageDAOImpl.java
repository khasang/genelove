package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.MessageDAO;
import io.khasang.genelove.entity.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public MessageDAOImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public Message getMessageById(int id) {
        TypedQuery<Message> query = sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM messages WHERE id = ?", Message.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
}
