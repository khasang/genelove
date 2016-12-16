package io.khasang.genelove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/sql")
public class SqlController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView sqls(){
        ModelAndView modelAndView=new ModelAndView("sql");

        return modelAndView;
    }
}
