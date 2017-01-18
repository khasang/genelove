package io.khasang.genelove.controller;

import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.Question;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.service.MessageService;
import io.khasang.genelove.service.QuestionService;
import io.khasang.genelove.model.SQLExamples;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.khasang.genelove.model.MyMessage;

import javax.servlet.http.HttpServletResponse;
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
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("message", myMessage.getMessage());
        return "hello";
    }

    /** Login user to system" */
    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "loginPage";
    }*/

    /** User registration" */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registrationPage";
    }

    /** User ends registration" */
    @RequestMapping(value = "/postRegistration", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object addNewUser(@RequestBody User user, HttpServletResponse response){
        String login = user.getLogin();
        if (userService.getUserByLogin(login)!= null) {
            return "User with login name " + login + " already exists, please try another name!";
        }
        try {
            userService.addUser(user);
            userService.addAuthorisation(user);
            return "You successfully registered!";
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error performing registration: " + e.getMessage();
        }
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
}
