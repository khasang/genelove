package io.khasang.genelove.controller;

import io.khasang.genelove.model.Message;
import io.khasang.genelove.model.MyMessage;
import io.khasang.genelove.model.SQLExamples;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    Message message;

    @Autowired
    MyMessage myMessage;

    @Autowired
    SQLExamples sqlExamples;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", message.getMessageOut());
        model.addAttribute("message", myMessage.getMessage());
        return "hello";
    }

    @RequestMapping("/sql")
    public String create(Model model) {
        model.addAttribute("create", sqlExamples.tableCreate());
        model.addAttribute("insert", sqlExamples.tableInsert());
        model.addAttribute("select", sqlExamples.tableSelect());
        return "sql";
    }
}
