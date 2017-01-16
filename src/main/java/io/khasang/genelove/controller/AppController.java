package io.khasang.genelove.controller;

import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.Question;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.service.MessageService;
import io.khasang.genelove.service.QuestionService;
import io.khasang.genelove.model.SQLExamples;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.khasang.genelove.model.MyMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    MyMessage myMessage;
    @Autowired
    SQLExamples sqlExamples;

    @Autowired
    CreateTable createTable;
    
    @Autowired
    QuestionService questionService;

    @Autowired
    MessageService messageService;

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("message", myMessage.getMessage());
        return "hello";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String createTable(Model model) {
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
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

    @RequestMapping(value = "/db/allQuestion", method = RequestMethod.GET)
    public String allQuestion(Model model) {
        List<Question> list = questionService.getQuetionList();
        model.addAttribute("allQuestion", list);
        return "questions";
    }


    @RequestMapping(value = "/db/message/{id}", method = RequestMethod.GET)
    public String getMessageById (@PathVariable("id") int id, Model model){
        model.addAttribute("message", messageService.getMessageById(id));
        return "message";
    }

    @RequestMapping(value = "/db/messagesAll", method = RequestMethod.GET)
    public String messagesAll(Model model) {
        List<Message> list = messageService.getMessageAll();
        model.addAttribute("messages", list);
        return "messages";
    }

    @RequestMapping("/sql/delete")
    public String delete(Model model) {
        model.addAttribute("delete", sqlExamples.tableDelete());
        return "sql";
    }

    @RequestMapping("/sql/create")
    public String create(Model model) {
        model.addAttribute("create", sqlExamples.tableCreate());
        return "sql";
    }

    @RequestMapping("/sql/insert")
    public String insert(Model model) {
        model.addAttribute("insert", sqlExamples.tableInsert());
        return "sql";
    }

    @RequestMapping("/sql/select")
    public String select(Model model) {
        model.addAttribute("select", sqlExamples.tableSelect());
        return "sql";
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
