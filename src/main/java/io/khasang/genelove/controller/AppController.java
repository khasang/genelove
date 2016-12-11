package io.khasang.genelove.controller;

import io.khasang.genelove.model.Contacts;
import io.khasang.genelove.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    Message message;

    @Autowired
    Contacts contacts;

    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", message.getMessageOut());
        return "hello";
    }

    @RequestMapping("/**")
    public String helloContacts(Model model){
        model.addAttribute("hello", contacts.getContactsOut());
        return "hello";
    }
}
