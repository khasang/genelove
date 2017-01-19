package io.khasang.genelove.service;

import io.khasang.genelove.dao.QuestionDAO;
import io.khasang.genelove.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("QuestionService")
@Transactional
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public void addQuestion(Question question) {
        questionDAO.addQuestion(question);
    }

    public Question getQuestionById(int id) {
        return questionDAO.getQuestionById(id);
    }

    public List getQuestionList() {
        return questionDAO.getQuestionList();
    }

    public void updateQuestion(Question question) {
        questionDAO.updateQuestion(question);
    }

    public void deleteQuestion(Question question) {
        questionDAO.deleteQuestion(question);
    }

}
