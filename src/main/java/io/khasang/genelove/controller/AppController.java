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
    CreateTable createTable;

    @Autowired
    InsertTable insertTable;

    @Autowired
    SimpleSelect simpleSelect;

    @Autowired
    MultipleSelect multipleSelect;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("index", "Hello World!!!");
        return "index";
        // There is my first inline comment
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("hello", "Hello World!!!");
        return "hello";
    }

    @RequestMapping("/db/create")
    public String createTable (Model model) {
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping("db/insert")
    public String insertTable (Model model) {
        model.addAttribute("insert", insertTable.insertTableStatus());
        return "insert";
    }

    @RequestMapping("db/simpleSelect")
    public String simpleSelect (Model model) {
        model.addAttribute("simpleSelect", simpleSelect.simpleSelectTableStatus());
        return "simpleSelect";
    }

    @RequestMapping("db/multipleSelect")
    public String multipleSelect (Model model) {
        model.addAttribute("multipleSelect", multipleSelect.multipleSelectTableStatus());
        return "multipleSelect";
    }
}
