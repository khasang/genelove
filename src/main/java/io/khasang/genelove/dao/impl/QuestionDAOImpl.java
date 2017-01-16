package io.khasang.genelove.dao.impl;

import io.khasang.genelove.dao.QuestionDAO;
import io.khasang.genelove.entity.Question;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class QuestionDAOImpl implements QuestionDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public QuestionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addQuestion(Question question) {
        sessionFactory.getCurrentSession().save(question);
    }

    @Override
    public void updateQuestion(Question question) {
        // saving old password if do not provided new
        final String query = "SELECT question from question WHERE id=:id";
        String oldQuestion = (String) sessionFactory.
                getCurrentSession().
                createNativeQuery(query).
                setParameter("id", question.getId()).
                uniqueResult();
        question.setQuestion(oldQuestion);
        sessionFactory.getCurrentSession().update(question);
    }

    @Override
    public void deleteQuestion(Question question) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(question);
        session.flush();
    }

    @Override
    public Question getQuestionById(int id) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Question.class);
        criteria.add(Restrictions.eq("id", id));
        return (Question) criteria.uniqueResult();
    }

    @Override
    public Question getQuestionByName(String name) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Question.class);
        criteria.add(Restrictions.eq("name", name));
        return (Question) criteria.uniqueResult();
    }

//    with criteria
    
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<Question> getQuestionList() {
//        Criteria criteria = sessionFactory.
//                getCurrentSession().
//                createCriteria(Question.class);
//        return (List<Question>) criteria.list();
//    }

    /**
     * with native sql
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Question> getQuestionList() {
        Query query = sessionFactory.getCurrentSession().createNativeQuery("select * from Question;");
        query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return query.list();
    }

}
