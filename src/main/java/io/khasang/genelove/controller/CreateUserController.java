package io.khasang.genelove.controller;

import io.khasang.genelove.model.SQLTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/createUsers")
public class CreateUserController {

    @Autowired
    private SQLTable sqlTable;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createUsersInDB(){
        ModelAndView modelAndView=new ModelAndView("testViews/index");
        modelAndView.addObject("sqlResultInsertUsers",sqlTable.insertUsers());
        return modelAndView;
    }
}
