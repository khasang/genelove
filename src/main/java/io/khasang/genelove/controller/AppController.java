package io.khasang.genelove.controller;

import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.Message;
import io.khasang.genelove.model.NewClass;
import io.khasang.genelove.model.SqlExample;
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

    @Autowired
    SqlExample sqlExample;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", message.getMessageOut());
        model.addAttribute("hello", message2.getMessOut());
        return "hello";
    }

    @RequestMapping("/admin/create")
    public String createTable(Model model){
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping("/db/insert")
    public String sqlInsertExecute(Model model){
        model.addAttribute("sql", sqlExample.sqlInsert());
        return "sqlexample";
    }

    @RequestMapping("/sql/join")
    public String sqlJoinExecute(Model model){
        model.addAttribute("sql", sqlExample.sqlJoin());
        return "sqlexample";
    }

    @RequestMapping("/sql/join2")
    public String sqlJoin2Execute(Model model) {
        model.addAttribute("sql", sqlExample.sqlJoin2());
        return "sqlexample";
    }

    @RequestMapping("/sql/attached")
    public String sqlAttachedExecute(Model model) {
        model.addAttribute("sql", sqlExample.sqlAttached());
        return "sqlexample";
    }

    @RequestMapping("/sql/case")
    public String sqlCaseExecute(Model model) {
        model.addAttribute("sql", sqlExample.sqlCase());
        return "sqlexample";
    }
}
