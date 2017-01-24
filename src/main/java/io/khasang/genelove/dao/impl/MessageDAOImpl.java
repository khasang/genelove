package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.MessageDAO;
import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.User;
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
import java.util.List;


@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public MessageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
    public List<Message> getMessageAll () {
        TypedQuery<Message> query = sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM messages", Message.class);
        return query.getResultList();
    }

    @Override
    public List<Message> getMessagesWith (int UserId, int OtherUserId) {
        TypedQuery<Message> query = sessionFactory.getCurrentSession().
                createNativeQuery("SELECT * FROM messages WHERE sender_id in ( :otherUserId, :userId) " +
                        "and receiver_id in (:userId, :otherUserId) order by created_date ", Message.class);
        query.setParameter("userId", UserId);
        query.setParameter("otherUserId", OtherUserId);
        return query.getResultList();
    }

    @Override
    public Message getMessageById (int id) {
        TypedQuery<Message> query = sessionFactory.getCurrentSession().createNativeQuery("" +
                "SELECT * FROM messages WHERE id = ?", Message.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    //var2 - criteria working
    /*@Override
    public Message getMessageById (int id) {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Message> cq = cb.createQuery(Message.class);
        Root<Message> root = cq.from(Message.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        cq.select(root).where(cb.equal(root.get("id"), p));
        TypedQuery<Message> query = sessionFactory.getCurrentSession().createQuery(cq);
        query.setParameter(p, id);
        return query.getSingleResult();
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
    public List<Message> getMessagesFrom(User sender) {
        TypedQuery<Message> query = sessionFactory.getCurrentSession().
                createNativeQuery("SELECT * FROM messages WHERE sender_id = :sender_id " +
                                     "order by created_date", Message.class);
        query.setParameter("sender_id", sender.getId());
        return query.getResultList();
    }

    @Override
    public List<Message> getMessagesTo(User receiver) {
        TypedQuery<Message> query = sessionFactory.getCurrentSession().
                createNativeQuery("SELECT * FROM messages WHERE receiver_id = :receiver_id " +
                                     "order by created_date", Message.class);
        query.setParameter("receiver_id", receiver.getId());
        return query.getResultList();
    }

    @Override
    public List<Message> getMessagesFromTo(User sender, User receiver) {
        TypedQuery<Message> query = sessionFactory.getCurrentSession().
                createNativeQuery("SELECT * FROM messages " +
                                     "WHERE sender_id = :sender_id and receiver_id = :receiver_id " +
                                     "order by created_date", Message.class);
        query.setParameter("sender_id", sender.getId());
        query.setParameter("receiver_id", receiver.getId());
        return query.getResultList();
    }
}
