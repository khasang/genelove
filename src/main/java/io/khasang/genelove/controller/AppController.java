package io.khasang.genelove.controller;

import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.entity_training.Question;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.MyMessage;
import io.khasang.genelove.model.SQLExamples;
import io.khasang.genelove.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletResponse;

import io.khasang.genelove.model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
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
    MailSender emailService;
    @Autowired
    Environment environment;
    @Autowired
    UserService userService;

    static int pageNum = 0;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String menuPage() {
        userService.update(); // to be removed
        return "redirect:/menuPage";
    }

    /**
     * User registration"
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registrationPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("registerUser") User user,
                               RedirectAttributes redirectAttributes) {
        String message;
        String login = user.getLogin();
        try {
            userService.getUserByLogin(login);
            return "User with login name " + login + " already exists, please try another name!";
        } catch (Exception ex) {

        }
        try {
            userService.addUser(user);
            userService.addAuthorisation(user);
            message = "User " + user.getLogin() + " successfully registered.";
        } catch (Exception e) {
            message = "Registration error " + e.getMessage();
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/account/menuPage";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String createTable(Model model) {
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("testViews/encode");
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
     */
    @RequestMapping(value = "/db/allQuestion", method = RequestMethod.GET)
    public String allQuestion(Model model, @RequestParam(value = "page", required = false) String page) {
        PagedListHolder questionList = new PagedListHolder(questionService.getQuestionList());
        questionList.setPageSize(4);

        if (page != null) {
            if ("previous".equals(page)) {
                questionList.previousPage();
                pageNum--;
                questionList.setPage(pageNum);
            } else if ("next".equals(page)) {
                questionList.nextPage();
                pageNum++;
                questionList.setPage(pageNum);
            } else {
                questionList.setPage(Integer.parseInt(page));
                pageNum = Integer.parseInt(page);
            }
        }

        model.addAttribute("allQuestion", questionList);
        return "testViews/questions";
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

    /*
    Stub controllers for jsp pages
    */
    SelectQuery selectQuery;
    @Autowired
    JoinQuery joinQuery;
    @Autowired
    ProfileServiceStub profileServiceStub;
    @Autowired
    FindPeopleService findPeopleService;

    @RequestMapping(value = "/support", method = RequestMethod.GET)
    public String support(Model model){
        model.addAttribute("support", "");
        return "support";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model){
        model.addAttribute("about", "");
        return "about";
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String services(Model model){
        model.addAttribute("services", "");
        return "services";
    }

    @RequestMapping(value = "/docs", method = RequestMethod.GET)
    public String docs(Model model){
        model.addAttribute("docs", "");
        return "docs";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(Model model){
        model.addAttribute("help", "");
        return "help";
    }

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String questions(Model model){
        model.addAttribute("questions", "");
        return "testViews/questions";
    }

    @RequestMapping(value = "/modifyProfile", method = RequestMethod.GET)
    public String modifyProfile(Model model){
        model.addAttribute("modifyProfile", "");
        return "modifyProfile";
    }

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public String tree(Model model){
        model.addAttribute("tree", "");
        return "tree";
    }

    @RequestMapping(value = "/profilePage", method = RequestMethod.GET)
    public ModelAndView profile(){
        return new ModelAndView("testViews/profilePage", "profile", profileServiceStub);
    }

    @RequestMapping(value = "/findPeople", method = RequestMethod.GET)
    public ModelAndView findPeople() {
        return new ModelAndView("findPeople","friends", profileServiceStub);
    }

    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public ModelAndView searchResult(HttpServletRequest request) {
        List<ProfileServiceStub> results = findPeopleService.findPeople(request.getParameter("firstName"),
                request.getParameter("lastName"), request.getParameter("region"),
                request.getParameter("minAge"), request.getParameter("maxAge"));
        return new ModelAndView("searchResult","results", results);
    }
}


