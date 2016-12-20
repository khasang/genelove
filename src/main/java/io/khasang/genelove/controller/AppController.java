package io.khasang.genelove.controller;

import io.khasang.genelove.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @Autowired
    Message message;

    @Autowired
    Contacts contacts;

    @Autowired
    CreateFilm createFilm;

    @Autowired
    CreateRole createRole;

    @Autowired
    TestTable testTable;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello", message.getMessageOut());
        return "hello";
    }

    @RequestMapping(value = "/manx/createFilm", method = RequestMethod.GET)
    public String createFilms(Model model) {
        model.addAttribute("createFilm", createFilm.createFilmStatus());
        return "createFilm";
    }

    @RequestMapping(value = "/manx/createRole", method = RequestMethod.GET)
    public String createRoles(Model model) {
        model.addAttribute("createRole", createRole.createRoleStatus());
        return "createRole";    }


    @RequestMapping(value = "/manx/insert", method = RequestMethod.GET)
    public String insertInto(Model model) {
        model.addAttribute("insert", testTable.insertTableStatus());
        return "insert";
    }

    @RequestMapping("/joinInner")
    public String joinInner(Model model) {
        model.addAttribute("joinInner", testTable.joinInnerStatus());
        return "joinInner";
    }

    @RequestMapping("/joinFullOuter")
    public String joinFullOuter(Model model) {
        model.addAttribute("joinFullOuter", testTable.joinFullOuterStatus());
        return "joinFullOuter";
    }

    @RequestMapping("/joinRightOuter")
    public String joinRightOuter(Model model) {
        model.addAttribute("joinRightOuter", testTable.joinRightOuterStatus());
        return "joinRightOuter";
    }

    @RequestMapping("/case")
    public String caseTable(Model model) {
        model.addAttribute("caseTable", testTable.caseTableStatus());
        return "case";
    }

    @RequestMapping("/select")
    public String select(Model model) {
        model.addAttribute("select", testTable.selectTableStatus());
        return "select";
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
    }
}
