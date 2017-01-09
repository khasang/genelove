package io.khasang.genelove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "/account")
public class UserController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registrationPage";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String checkMessage() {
        return "registrationPage";
    }


}
