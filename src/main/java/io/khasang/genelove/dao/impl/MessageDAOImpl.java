package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.MessageDAO;
import io.khasang.genelove.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public MessageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addMessage(Message message) {
        this.sessionFactory.getCurrentSession().save(message);
    }

    @Override
    public void deleteMessage(Message message) {
        Session session = this.sessionFactory.getCurrentSession();
        Message wasteMessage = session.get(Message.class, message.getId());
        session.delete(wasteMessage);
    }

}
