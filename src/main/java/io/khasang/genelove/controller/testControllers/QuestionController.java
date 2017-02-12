package io.khasang.genelove.controller.testControllers;

import io.khasang.genelove.entity.entity_training.Question;
import io.khasang.genelove.model.Utils;
import io.khasang.genelove.service.testServices.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    PagedListHolder questionList = new PagedListHolder();

    /**
     * Example request http://localhost:8080/db/allQuestion?page=next
     * (see also "model/Utils.paginateList" and testViews/questions.jsp)
     */
    @RequestMapping(value = "/db/allQuestion", method = RequestMethod.GET)
    public String allQuestion(Model model, @RequestParam(value = "page", required = false) String page) {
        questionList.setSource(questionService.getQuestionList());

        model.addAttribute("allQuestion", Utils.paginateList(questionList, page, 4, model));
        return "testViews/questions";
    }

    @RequestMapping(value = "/db/addQuestion", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object addQuestion(@RequestBody Question question, HttpServletResponse response) {
        try {
            questionService.addQuestion(question);
            return question;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding question: " + e.getMessage();
        }
    }

}


