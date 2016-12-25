package io.khasang.genelove.controller;

import io.khasang.genelove.model.SQLTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adm-sql")
public class SqlController {

    @Autowired
    private SQLTable sqlTable;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView sqls(){
        ModelAndView modelAndView=new ModelAndView("sql");
      //  modelAndView.addObject("sqlResultCrearteTable",sqlTable.createTable());
        modelAndView.addObject("sqlResultInsertTable",sqlTable.insertTable());
        return modelAndView;
    }
}
