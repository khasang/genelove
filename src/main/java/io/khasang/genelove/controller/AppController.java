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
    SelectQuery selectQuery;
    @Autowired
    CaseQuery caseQuery;
    @Autowired
    InserData insertData;
    @Autowired
    JoinQuery joinQuery;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello", message.getMessage());
        return "hello";
    }

    @RequestMapping(value = "/db/create", method = RequestMethod.GET)
    public String createTable(Model model){
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = "/db/select", method = RequestMethod.GET)
    public String selectData(Model model) {
        model.addAttribute("select", selectQuery.selectData());
        return "select";
    }

    @RequestMapping(value = "/db/selectCase", method = RequestMethod.GET)
    public String selectWithCase(Model model) {
        model.addAttribute("selectCase", caseQuery.caseQuery());
        return "selectCase";
    }

    @RequestMapping(value = "/db/insert", method = RequestMethod.GET)
    public String insertData(Model model) {
        model.addAttribute("insert", insertData.inserData());
        return "insert";
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
}
