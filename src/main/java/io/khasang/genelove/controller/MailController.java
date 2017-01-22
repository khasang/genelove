package io.khasang.genelove.controller;

import io.khasang.genelove.entity.EMail;
import io.khasang.genelove.entity.User;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Controller
public class MailController {
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
    @Autowired
    DBLoader dbLoader;

    /*********************************** Mail Sender Service *******************************
    * In this section represents code of Mail Sender Service.
    * Begin of this section here.
    ***************************************************************************************/
    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public String mailSender() {
        return "mailService/sendMail";
    }

    @RequestMapping(value = "/insertUsersIntoDB", method = RequestMethod.GET)
    public String addUsersIntoDB(Model model) {
        String response = dbLoader.addUsersIntoDB();
        model.addAttribute("message", response);
        if (response.equals("Ok"))
            return "mailService/sendMailResult";
        else {
            model.addAttribute("errorMessage", response);
            return "mailService/sendMailError";
        }
    }

    @RequestMapping(value = "/viewAllUsers", method = RequestMethod.GET)
    public String viewAllUsers(Model model) {
        String message = "View all users from our database \"User\"";
        model.addAttribute("message", message);
        model.addAttribute("usersList", userService.getUserAll());
        return "mailService/viewUsersList";
    }

    @RequestMapping(value = "/viewAllEMails", method = RequestMethod.GET)
    public String viewAllUEMails(Model model) {
        String message = "View all E-Mails";
        model.addAttribute("message", message);
        model.addAttribute("eMailsList", userService.getUserAll());
        return "mailService/viewEMailsList";
    }

    @RequestMapping(value = "/noAction", method = RequestMethod.POST)
    public String noAction(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        String message = "This is blank for the future usage";
        model.addAttribute("message", message);
        return "mailService/sendMailResult";
    }

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF8");

        if (request.getParameter("recipient").equals("")) {
            String message = "Recipient's address is null";
            model.addAttribute("errorMessage", message);
            return "mailService/sendMailError";
        }
            EMail eMail = new EMail(
                    request.getParameter("recipient"),
                    environment.getProperty("mail.username"),
                    request.getParameter("subject"),
                    request.getParameter("message")
            );
        emailService.setEmailFields(eMail);

        try {
            emailService.sendEmail(eMail);
            String message = "Your Mail was successfully delivered to Recipient";
            model.addAttribute("message", message);
            return "mailService/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "mailService/sendMailError";
        }
    }

    @RequestMapping(value = "/sendMailToAllUsers", method = RequestMethod.GET)
    public String sendMailToAllUsersGET(Model model) {
        String message = "Do you wanna send the e-Mail to all users in really?";
        model.addAttribute("message", message);
        return "mailService/sendMailToAllUsers";
    }

    @RequestMapping(value = "/sendMailToAllUsers", method = RequestMethod.POST)
    public String sendMailToAllUsersPOST(HttpServletRequest request, Model model)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF8");
        ArrayList<User> listOfRecipients = (ArrayList<User>) userService.getUserAll();
        EMail eMail = new EMail(
                environment.getProperty("mail.username"),
                request.getParameter("subject"),
                request.getParameter("message")
        );
        emailService.setEmailFields(eMail);

        try {
            int count = emailService.sendEmail(listOfRecipients, eMail);
            String message = "Your Mail was successfully delivered to All <strong>" +
                    count + "</strong> Recipients";
            model.addAttribute("message", message);
            return "mailService/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "mailService/sendMailError";
        }
    }

    @RequestMapping(value = "/sendMailById/{id}", method = RequestMethod.GET)
    public String sendMailByIdGET(@PathVariable("id") int id, Model model) {
        String message = "Do you wanna send the message to user (ID = <strong>" +
                id+ "</strong>) in really? ";
        model.addAttribute("message", message);
        model.addAttribute("id", id);
        return "mailService/sendMailById";
    }

    @RequestMapping(value = "/sendMailById/send", method = RequestMethod.POST)
    public String sendMailByIdPOST(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF8");
        int recipient = Integer.valueOf(request.getParameter("recipient"));
        EMail eMail = new EMail(
                userService.getUserById(recipient).getEmail(),
                environment.getProperty("mail.username"),
                request.getParameter("subject"),
                request.getParameter("message")
        );
        emailService.setEmailFields(eMail);

        try {
            emailService.sendEmail(eMail);
            String id = request.getParameter("recipient");
            String message = "Your Mail was successfully delivered to Recipient with ID = " + id;
            model.addAttribute("message", message);
            return "mailService/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "mailService/sendMailError";
        }
    }

    @RequestMapping(value = "/sendMailToUser", method = RequestMethod.POST)
    public String doSendEmailToUser(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        User user = new User();
        user.setEmail("python239@mail.ru");
        user.setFirstName("Alexander");
        user.setLastName("Pyankov");
        user.setGender("male");

        try {
            emailService.sendEmail(user);
            String message = "Your Mail was successfully delivered to Recipient";
            model.addAttribute("message", message);
            return "mailService/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "mailService/sendMailError";
        }
    }

    @RequestMapping(value = "/sendMailToSomeUsers", method = RequestMethod.POST)
    public String doSendEmailToSomeUsers(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();

        User user1 = new User();
        user1.setEmail("python239@mail.ru");
        user1.setFirstName("Alexander");
        user1.setLastName("Pyankov");
        user1.setGender("male");

        User user2 = new User();
        user2.setEmail("python239@mail.ru");
        user2.setFirstName("Robert");
        user2.setLastName("Stivenson");
        user2.setGender("male");

        User user3 = new User();
        user3.setEmail("python239@mail.ru");
        user3.setFirstName("Alexander");
        user3.setLastName("Miln");
        user3.setGender("male");

        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        try {
            emailService.sendEmail(list);
            String message = "Your Mail was successfully delivered to Recipients";
            model.addAttribute("message", message);
            return "mailService/sendMailResult";

        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "mailService/sendMailError";
        }
    }
    /*************************** End of the Mail Sender Service ****************************/
}
