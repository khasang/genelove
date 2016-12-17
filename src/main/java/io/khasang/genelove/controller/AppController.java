package io.khasang.genelove.controller;

import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.InsertTable;
import io.khasang.genelove.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    Message message;

    @Autowired
    CreateTable createTable;

    @Autowired
    InsertTable insertTable;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", "Hello World!!!");
        return "hello";
        // There is my first inline comment
    }

    @RequestMapping("/create")
    public String createTable (Model model) {
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }
    @RequestMapping("/insert")
    public String insertTable (Model model) {
        model.addAttribute("insert", insertTable.insertTableStatus());
        return "insert";
    }
}
