package io.khasang.genelove.controller;

import io.khasang.genelove.entity.Question;
import io.khasang.genelove.model.*;
import io.khasang.genelove.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class AppController {

    @Autowired
    Message message;

    @Autowired
    QuestionService questionService;

    @Autowired
    CreateTable createTable;

    @Autowired
    InsertTable insertTable;

    @Autowired
    SimpleSelect simpleSelect;

    @Autowired
    MultipleSelect multipleSelect;

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("index", "Hello World!!!");
        return "index";
        // There is my first inline comment
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
    }

    @RequestMapping(value = "db/addQuestion", method = RequestMethod.POST, produces = "application/json")
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

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello", "Hello World!!!");
        return "hello";
    }

    @RequestMapping(value = "/db/create", method = RequestMethod.GET)
    public String createTable (Model model) {
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = "db/insert", method = RequestMethod.GET)
    public String insertTable (Model model) {
        model.addAttribute("insert", insertTable.insertTableStatus());
        return "insert";
    }

    @RequestMapping(value = "db/simpleSelect", method = RequestMethod.GET)
    public String simpleSelect (Model model) {
        model.addAttribute("simpleSelect", simpleSelect.simpleSelectTableStatus());
        return "simpleSelect";
    }

    @RequestMapping(value = "db/multipleSelect", method = RequestMethod.GET)
    public String multipleSelect (Model model) {
        model.addAttribute("multipleSelect", multipleSelect.multipleSelectTableStatus());
        return "multipleSelect";
    }

    @RequestMapping(value = "/db/allQuestion", method = RequestMethod.GET)
    public String allQuestion(Model model) {
        List<Question> list = questionService.getQuetionList();
        model.addAttribute("allQuestion", list);
        return "questions";
    }

    @RequestMapping(value = "/db/getQuestionById/{id}", method = RequestMethod.GET)
    public String getQuestionById(@PathVariable("id") int id, Model model) {
        Question question = questionService.getQuestionById(id);
        model.addAttribute("getQuestionById", question);
        return "question";
    }

    @RequestMapping(
            value = "/db/deleteQuestionById/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    @ResponseBody
    public String deleteQuestionById(@PathVariable(value = "id") String inputId, HttpServletResponse response) {
        try {
            int questionId = Integer.valueOf(inputId);
            Question question = questionService.getQuestionById(questionId);
            if (question != null) {
                questionService.deleteQuestion(question);
                return "Question #" + questionId + " successfully deleted.";
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "Question #" + questionId + " not found.";
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Bad question id format: " + inputId;
        }
    }

    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public String openMailForm(Model model) {
        return "emailtest/emailform";
    }

    /** Sending e-mail message to client" */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();

        try {
            // takes input from e-mail form
            request.setCharacterEncoding("UTF8");
            String recipientAddress = request.getParameter("recipient");
            String subject = request.getParameter("subject");
            String message = request.getParameter("message");

            // creates a simple e-mail object
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom("dendrito@list.ru");
            email.setTo(recipientAddress);
            email.setSubject(subject);
            email.setText(message);

            // sends the e-mail
            mailSender.send(email);

            // forwards to the view named "Result"
            return "emailtest/emailresult";

        } catch(Exception mess){
            model.addAttribute("exception", mess.getMessage());
            return "emailtest/emailerror";
        }
    }
}
