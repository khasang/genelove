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

    @RequestMapping(value = "/", method = RequestMethod.GET)
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

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello", "Hello World!!!");
        return "hello";
    }

    @RequestMapping(value = "/db/create", method = RequestMethod.GET)
    public String createTable (Model model) {
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = "db/insert", method = RequestMethod.GET)
    public String insertTable (Model model) {
        model.addAttribute("insert", insertTable.insertTableStatus());
        return "insert";
    }

    @RequestMapping(value = "db/simpleSelect", method = RequestMethod.GET)
    public String simpleSelect (Model model) {
        model.addAttribute("simpleSelect", simpleSelect.simpleSelectTableStatus());
        return "simpleSelect";
    }

    @RequestMapping(value = "db/multipleSelect", method = RequestMethod.GET)
    public String multipleSelect (Model model) {
        model.addAttribute("multipleSelect", multipleSelect.multipleSelectTableStatus());
        return "multipleSelect";
    }
}
