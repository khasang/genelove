package io.khasang.genelove.controller;

import io.khasang.genelove.model.*;
import io.khasang.genelove.service.FindPeopleService;
import io.khasang.genelove.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    SelectQuery selectQuery;
    @Autowired
    JoinQuery joinQuery;
    @Autowired
    ProfileService profileService;
    @Autowired
    FindPeopleService findPeopleService;
    /*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello", message.getMessage());
        return "hello";
    }
    */
    @RequestMapping(value = "/db/select", method = RequestMethod.GET)
    public String selectData(Model model) {
        model.addAttribute("select", selectQuery.selectData());
        return "select";
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

    /*
    Stub controllers for jsp pages
     */
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

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(){
        return new ModelAndView("profile", "profile", profileService);
    }

    @RequestMapping(value = "/findPeople", method = RequestMethod.GET)
    public ModelAndView findPeople() {
        return new ModelAndView("findPeople","friends", profileService);
    }
    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public ModelAndView searchResult(HttpServletRequest request) {
        List<ProfileService> results = findPeopleService.findPeople(request.getParameter("firstName"),
                request.getParameter("lastName"), request.getParameter("region"),
                request.getParameter("minAge"), request.getParameter("maxAge"));
        return new ModelAndView("searchResult","results", results);
    }
}
