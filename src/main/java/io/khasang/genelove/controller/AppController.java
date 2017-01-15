package io.khasang.genelove.controller;

import io.khasang.genelove.entity.Credentials;
import io.khasang.genelove.model.*;
import io.khasang.genelove.service.ProfileService;
import io.khasang.genelove.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class AppController {
    @Autowired
    Message message;
    @Autowired
    CreateTable createTable;
    @Autowired
    SelectQuery selectQuery;
    @Autowired
    CaseQuery caseQuery;
    @Autowired
    InserData insertData;
    @Autowired
    JoinQuery joinQuery;
    @Autowired
    UsersService usersService;
    @Autowired
    ProfileService profileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello", message.getMessage());
        return "hello";
    }

    @RequestMapping(value = "/db/create", method = RequestMethod.GET)
    public String createTable(Model model){
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = "/db/select", method = RequestMethod.GET)
    public String selectData(Model model) {
        model.addAttribute("select", selectQuery.selectData());
        return "select";
    }

    @RequestMapping(value = "/db/selectCase", method = RequestMethod.GET)
    public String selectWithCase(Model model) {
        model.addAttribute("selectCase", caseQuery.caseQuery());
        return "selectCase";
    }

    @RequestMapping(value = "/db/insert", method = RequestMethod.GET)
    public String insertData(Model model) {
        model.addAttribute("insert", insertData.inserData());
        return "insert";
    }

    @RequestMapping(value = "/db/join", method = RequestMethod.GET)
    public String joinData(Model model) {
        model.addAttribute("join", joinQuery.join());
        return "join";
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
    }

    @RequestMapping(value = "/db/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Object addUser(Credentials credentials, HttpServletResponse response) {
        try {
            usersService.addUser(credentials);
            return credentials;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding user " + e.getMessage();
        }
    }

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
        return "questions";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model){
        model.addAttribute("logout", "");
        return "logout";
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String messages(Model model){
        model.addAttribute("messages", "");
        return "messages";
    }

    @RequestMapping(value = "/findPeople", method = RequestMethod.GET)
    public String findPeople(Model model){
        model.addAttribute("findPeople", new ArrayList<String>() {});
        return "findPeople";
    }

    @RequestMapping(value = "/myPage", method = RequestMethod.GET)
    public String myPage(Model model){
        model.addAttribute("myPage", "");
        return "myPage";
    }

    @RequestMapping(value = "/modifyProfile", method = RequestMethod.GET)
    public String modifyProfile(Model model){
        model.addAttribute("modifyProfile", "");
        return "modifyProfile";
    }

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public ModelAndView friends(Model model){
        model.addAttribute("friends", "");
        return new ModelAndView("invites","friends", profileService.getFriendsList(""));
    }

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public String tree(Model model){
        model.addAttribute("tree", "");
        return "tree";
    }
}
