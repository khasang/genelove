package io.khasang.genelove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/menuPage")
public class MenuController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView menuPage(){
        ModelAndView modelAndView=new ModelAndView("menuPage");
        String[] list={"user1","user2","user3","user4","user5","user6","user7","user8",};
        modelAndView.addObject("list",list);
        return modelAndView;
    }

}
