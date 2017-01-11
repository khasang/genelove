package io.khasang.genelove.controller;

import io.khasang.genelove.model.SQLTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    SQLTable sqlTable;

    @RequestMapping("/page")
    public String hello(Model model){
        model.addAttribute("hello", "Hello World");
        return "hello";
    }
}
