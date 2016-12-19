package io.khasang.genelove.controller;

import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.Message;
import io.khasang.genelove.model.NewClass;
import io.khasang.genelove.model.SqlExample;
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
    NewClass message2;

    @Autowired
    CreateTable createTable;

    @Autowired
    SqlExample sqlExample;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("hello", message.getMessageOut());
        model.addAttribute("hello", message2.getMessOut());
        return "hello";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String createTable(Model model){
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = "/db/insert", method = RequestMethod.GET)
    public String sqlInsertExecute(Model model){
        model.addAttribute("sql", sqlExample.sqlInsert());
        return "sqlexample";
    }

    @RequestMapping(value = "/sql/join", method = RequestMethod.GET)
    public String sqlJoinExecute(Model model){
        model.addAttribute("sql", sqlExample.sqlJoin());
        return "sqlexample";
    }

    @RequestMapping(value = "/sql/join2", method = RequestMethod.GET)
    public String sqlJoin2Execute(Model model) {
        model.addAttribute("sql", sqlExample.sqlJoin2());
        return "sqlexample";
    }

    @RequestMapping(value = "/sql/attached", method = RequestMethod.GET)
    public String sqlAttachedExecute(Model model) {
        model.addAttribute("sql", sqlExample.sqlAttached());
        return "sqlexample";
    }

    @RequestMapping(value = "/sql/case")
    public String sqlCaseExecute(Model model) {
        model.addAttribute("sql", sqlExample.sqlCase());
        return "sqlexample";
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
    }
}
