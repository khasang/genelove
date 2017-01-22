package io.khasang.genelove.controller;

import io.khasang.genelove.model.DBLoader;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.MyMessage;
import io.khasang.genelove.model.SQLExamples;
import io.khasang.genelove.service.MailSender;
import io.khasang.genelove.service.MessageService;
import io.khasang.genelove.service.QuestionService;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessengerController {
    @Autowired
    MyMessage myMessage;
    @Autowired
    SQLExamples sqlExamples;
    @Autowired
    CreateTable createTable;
    @Autowired
    QuestionService questionService;
    @Autowired
    MessageService messageService;
    @Autowired
    MailSender emailService;
    @Autowired
    Environment environment;
	@Autowired
    UserService userService;

    /********************************* Private Message Service ******************************
    * In this section represents code of Mail Sender Service.
    * Begin of this section here.
    ***************************************************************************************/
    @RequestMapping(value = "/messenger", method = RequestMethod.GET)
    public String messenger(Model model) {
        String message = "Your Message Box is empty.<br>" +
                "You haven't get any messages yet.";
        model.addAttribute("message", message);
        return "mailService/messenger";
    }

    @RequestMapping(value = "/sendMailToGroupOfUsers", method = RequestMethod.POST)
    public String sendMailToGroupOfUsers(Model model) {
        String message = "Send Mail to selected users";
        model.addAttribute("message", message);
        return "mailService/sendMailToSelectedUsers";
    }
    /************************** End of the Private Message Service *************************/
}
