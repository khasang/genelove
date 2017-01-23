package io.khasang.genelove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/myTree")
public class MyTreeController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView meTreeAcount(){
        ModelAndView modelAndView=new ModelAndView("myTree");
        return modelAndView;
    }
}
