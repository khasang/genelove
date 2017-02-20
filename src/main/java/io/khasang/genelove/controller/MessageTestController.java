package io.khasang.genelove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/myMessages")
public class MessageTestController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView myMesages(){
        ModelAndView modelAndView=new ModelAndView("messages");
        List<String> name=new ArrayList<>();
        name.add("Ivan");
        name.add("Oleg");
        name.add("Nadia");
        name.add("Diana");
        name.add("Marina");
        name.add("Roman");
        modelAndView.addObject("messageList",name);
        return modelAndView;
    }
}
