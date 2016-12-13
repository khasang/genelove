package io.khasang.genelove.controller;

import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.Message;
import io.khasang.genelove.model.NewClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    Message message;

    @Autowired
    NewClass message2;

    @Autowired
    CreateTable createTable;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", message.getMessageOut());
        model.addAttribute("hello", message2.getMessOut());
        return "hello";
    }

    @RequestMapping("/create")
    public String createTable(Model model){
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }
}
