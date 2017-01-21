package io.khasang.genelove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/menuPage")
public class MenuController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView menuPage(){
        ModelAndView modelAndView=new ModelAndView("menuPage");
        return modelAndView;
    }

}
