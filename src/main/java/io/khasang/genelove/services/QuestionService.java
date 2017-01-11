package io.khasang.genelove.services;

import io.khasang.genelove.dao.QuestionDAO;
import io.khasang.genelove.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
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

    public List<Question> getQuetionList() {
        return questionDAO.getQuestionList();
    }

    public void updateQuestion(Question question) {
        questionDAO.updateQuestion(question);
    }

    public void deleteQuestion(Question question) {
        questionDAO.deleteQuestion(question);
    }


}
