package io.khasang.genelove.controller;

import io.khasang.genelove.model.LembergMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lembergIP on 09.12.2016.
 */
@Controller
public class LembergController {

@Autowired
private LembergMessage lembergMessage;

    @RequestMapping("/lemberg")
    public ModelAndView sum2numbers(){
        ModelAndView modelAndView=new ModelAndView("lemberg");
        modelAndView.addObject("lembergMessage",lembergMessage.sumTwoNumbers(11,23));
        return modelAndView;
    }
}
