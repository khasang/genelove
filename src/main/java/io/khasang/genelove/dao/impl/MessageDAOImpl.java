package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.MessageDAO;
import io.khasang.genelove.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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

    @Override
    public void editMessage (Message message) {
    }

    @Override
    public Message getMessageById (int id) {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Message> cq = cb.createQuery(Message.class);
        Root<Message> root = cq.from(Message.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        cq.select(root).where(cb.equal(root.get("id"), p));
        TypedQuery<Message> query = sessionFactory.getCurrentSession().createQuery(cq);
        query.setParameter(p, id);
        return query.getSingleResult();
    }

    //var2 criteria - working
    /*public Message getMessageById (int id) {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Message> cq = cb.createQuery(Message.class);
        Root<Message> root = cq.from(Message.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        cq.select(root).where(cb.equal(root.get("id"), p));
        TypedQuery<Message> query = sessionFactory.getCurrentSession().createQuery(cq);
        query.setParameter(p, id);
        return query.getSingleResult();
    }*/

    //var1 - java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to io.khasang.genelove.entity.Message
    /*public Message getMessageById (int id) {
        String sql = "SELECT id, text from messages WHERE id=:id";
        Query query = sessionFactory.getCurrentSession().createNativeQuery(sql);
        query.setParameter("id", id);
        //List is used to escape unchecked exception
        List results = query.getResultList();
        Message foundMessage = null;
        if(!results.isEmpty()) {
            //ignores multiple results
            foundMessage = (Message) results.get(0);
        }
        return foundMessage;
    }*/



    @Override
    public List<Message> getMessageByKeyWord (String keyWord) {
        List<Message> messagesByKeyWord = new ArrayList<>();
        //
        return messagesByKeyWord;
    }

    @Override
    public List<Message> getMessageByDate (String date) {
        List<Message> messagesByDate = new ArrayList<>();
        //
        return messagesByDate;
    }

    @Override
    public List<Message> getMessageAll () {
        List<Message> messagesALL = new ArrayList<>();
        //
        return messagesALL;
    }

}
