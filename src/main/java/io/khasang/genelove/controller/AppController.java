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
    CreateFilms createFilms;

    @Autowired
    CreateRoles createRoles;

    @Autowired
    InsertInto insertInto;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", message.getMessageOut());
        return "hello";
    }

    /*@RequestMapping("/**")
    public String helloContacts(Model model){
        model.addAttribute("hello", contacts.getContactsOut());
        return "hello";
    }*/

    @RequestMapping("/createfilms")
    public String createFilms(Model model) {
        model.addAttribute("createfilms", createFilms.createFilmsStatus());
        return "createfilms";
    }

    @RequestMapping("/createroles")
    public String createRoles(Model model) {
        model.addAttribute("createroles", createRoles.createRolesStatus());
        return "createroles";    }


    @RequestMapping("/insert")
    public String insertInto(Model model) {
        model.addAttribute("insert", insertInto.insertIntoStatus());
        return "insert";
    }
}
