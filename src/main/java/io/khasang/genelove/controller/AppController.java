package io.khasang.genelove.controller;

import io.khasang.genelove.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", message.getMessageOut());
        return "hello";
    }

    @RequestMapping("/createFilm")
    public String createFilms(Model model) {
        model.addAttribute("createFilm", createFilm.createFilmStatus());
        return "createFilm";
    }

    @RequestMapping("/createRole")
    public String createRoles(Model model) {
        model.addAttribute("createRole", createRole.createRoleStatus());
        return "createRole";    }


    @RequestMapping("/insert")
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

    /*@RequestMapping("/case")
    public String caseTable(Model model) {
        model.addAttribute("caseTable", testTable.caseTableStatus());
        return "case";
    }*/

    @RequestMapping("/select")
    public String select(Model model) {
        model.addAttribute("select", testTable.selectTableStatus());
        return "select";
    }
}
