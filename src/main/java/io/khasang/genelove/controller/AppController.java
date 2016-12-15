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
    CreateTable createTable;
    @Autowired
    SelectQuery selectQuery;
    @Autowired
    CaseQuery caseQuery;
    @Autowired
    InserData insertData;
    @Autowired
    JoinQuery joinQuery;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", message.getMessage());
        return "hello";
    }

    @RequestMapping("/create")
    public String createTable(Model model){
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping("/select")
    public String selectData(Model model) {
        model.addAttribute("select", selectQuery.selectData());
        return "select";
    }

    @RequestMapping("/selectCase")
    public String selectWithCase(Model model) {
        model.addAttribute("selectCase", caseQuery.caseQuery());
        return "selectCase";
    }

    @RequestMapping("/insert")
    public String insertData(Model model) {
        model.addAttribute("insert", insertData.inserData());
        return "insert";
    }

    @RequestMapping("/join")
    public String joinData(Model model) {
        model.addAttribute("join", joinQuery.join());
        return "join";
    }
}
