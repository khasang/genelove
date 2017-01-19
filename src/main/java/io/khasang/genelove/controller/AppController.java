package io.khasang.genelove.controller;

import io.khasang.genelove.entity.EMail;
import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.Question;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.MyMessage;
import io.khasang.genelove.model.SQLExamples;
import io.khasang.genelove.service.EmailService;
import io.khasang.genelove.service.MessageService;
import io.khasang.genelove.service.QuestionService;
import io.khasang.genelove.model.SQLExamples;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.khasang.genelove.model.MyMessage;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
    EmailService emailService;
    @Autowired
    Environment environment;
	@Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("registerUser") User user,
                               RedirectAttributes redirectAttributes) {
        String message;
        try {
            userService.addUser(user);
            message = "User " + user.getLogin() + " successfully registered.";
        } catch (Exception e) {
            message = "Registration error " + e.getMessage();
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/login";
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

    /**
     * Example request http://localhost:8089/db/allQuestion?page=next
     * */
    @RequestMapping(value = "/db/allQuestion", method = RequestMethod.GET)
    public String allQuestion(Model model, @RequestParam(value = "page", required = false) String page) {
        PagedListHolder myList = new PagedListHolder(questionService.getQuestionList());
        myList.setPageSize(4);

        if(page != null) {
            if ("previous".equals(page)) {
                myList.previousPage();
            } else if ("next".equals(page)) {
                myList.nextPage();
            }
        }

        model.addAttribute("allQuestion", myList);
        return "questions";
    }


    @RequestMapping(value = "/db/message/{id}", method = RequestMethod.GET)
    public String getMessageById(@PathVariable("id") int id, Model model) {
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

    /**
     * Open new e-mail form to send"
     */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public String openMailForm() {
        return "emailtest/emailForm";
    }

    /**
     * Open new e-mail form to send"
     */

    @RequestMapping(value = "/sendEmailToUser", method = RequestMethod.GET)
    public String openMailFormToUser() {
        return "emailtest/email2User";
    }

    @RequestMapping(value = "/sendEmailToSomeUsers", method = RequestMethod.GET)
    public String openMailFormToSomeUsers() {
        return "emailtest/email2SomeUsers";
    }

    /**
     * Sending e-mail message to client"
     */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();
        request.setCharacterEncoding("UTF8");

        EMail eMail = new EMail(
                request.getParameter("recipient"),
                environment.getProperty("mail.username"),
                request.getParameter("subject"),
                request.getParameter("message")
        );
        emailService.setEmailFields(eMail);

        try {
            emailService.sendEmail(request);

            // forwards to the view named "Result"
            return "emailtest/emailResult";

        } catch (Exception mess) {
            model.addAttribute("exception", mess.getMessage());
            return "emailtest/emailError";
        }
    }

    // Sending e-mail message to client (user)
    @RequestMapping(value = "/sendEmailToUser", method = RequestMethod.POST)
    public String doSendEmailToUser(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();

        User user = new User();
        /*user.setEmail("python239@mail.ru");
        user.setFirstName("Alexander");
        user.setLastName("Pyankov");
        user.setGender("male");*/

        user.setGender("male");

        try {
            emailService.sendEmail(user);

            // forwards to the view named "Result"
            return "emailtest/emailResult2User";

        } catch (Exception mess) {
            model.addAttribute("exception", mess.getMessage());
            return "emailtest/emailError2User";
        }
    }

    // Sending e-mail message to client (user)
    @RequestMapping(value = "/sendEmailToSomeUsers", method = RequestMethod.POST)
    public String doSendEmailToSomeUsers(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();

        /*User user1 = new User();
        user1.setEmail("python239@mail.ru");
        user1.setFirstName("Alexander");
        user1.setLastName("Pyankov");
        user1.setGender("male");

        User user2 = new User();
        user2.setEmail("dendrito@list.ru");
        user2.setFirstName("Denis");
        user2.setLastName("Guzikov");
        user2.setGender("male");*/

        /*ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);*/


        try {
//            emailService.sendEmail(list);

            // forwards to the view named "Result"
            return "emailtest/emailResult2SomeUsers";

        } catch (Exception mess) {
            model.addAttribute("exception", mess.getMessage());
            return "emailtest/emailError2SomeUsers";
        }
    }
}
