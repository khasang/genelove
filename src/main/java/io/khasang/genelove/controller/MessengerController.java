package io.khasang.genelove.controller;

import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.MyMessage;
import io.khasang.genelove.model.SQLExamples;
import io.khasang.genelove.service.MailSender;
import io.khasang.genelove.service.MessageService;
import io.khasang.genelove.service.QuestionService;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

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

    private String getCurrentUserName () {
        User currentUser = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        String name = currentUser.getFirstName();
        String lastName = currentUser.getLastName();
        if (name != null && lastName != null)
            return name + " " + lastName;
        else return "Anonymous User";
    }

    /********************************* Private Message Service ******************************
    * In this section represents code of Mail Sender Service.
    * Begin of this section here.
    ***************************************************************************************/
    @RequestMapping(value = "/messenger", method = RequestMethod.GET)
    public String messenger(Model model) {
        model.addAttribute("currentUser", getCurrentUserName());
        String message = "Your Message Box is empty.<br>" +
                "You haven't get any messages yet.";
        model.addAttribute("message", message);
        return "mailService/messenger";
    }

    @RequestMapping(value = "/sendMessageById/{id}", method = RequestMethod.GET)
    public String sendMessageByIdGET(@PathVariable("id") int id, Model model) {
        String message = "Do you wanna send the Private Message to user (ID = <strong>" +
                id+ "</strong>) in really? ";
        model.addAttribute("currentUser", getCurrentUserName());
        model.addAttribute("message", message);
        model.addAttribute("id", id);
        return "mailService/sendMessageById";
    }

    @RequestMapping(value = "/sendMessageById/send", method = RequestMethod.POST)
    public String sendMessageByIdPOST(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF8");
        model.addAttribute("currentUser", getCurrentUserName());
        int receiver_id = Integer.parseInt(request.getParameter("recipient"));
        String text = request.getParameter("privateMessage");

        Message privateMessage = new Message(
                userService.getUserById(receiver_id),
                userService.getUserById(2),
                text
        );

        System.out.println("*********** Message Constructor ***********");
        System.out.println("Private Message Sender: " + userService.getUserById(receiver_id));
        System.out.println("Private Message Receiver: " + userService.getUserById(receiver_id));
        System.out.println("Private Message Creation Date: " + privateMessage.getCreatedDate());
        System.out.println("Private Message Sent Date: " + privateMessage.getSentDate());
        System.out.println("Private Message Received Date: " + privateMessage.getReceivedDate());
        System.out.println("Private Message Status: " + privateMessage.getMessageStatus());
        System.out.println("Private Message Text: " + privateMessage.getText());
        System.out.println("*******************************************");

        System.out.println("********** Messenger Controller ***********");
        System.out.println("Private Message ID: " + privateMessage.getId());
        System.out.println("Private Message Sender: " + privateMessage.getSender());
        System.out.println("Private Message Receiver: " + privateMessage.getReceiver());
        System.out.println("Private Message Creation Date: " + privateMessage.getCreatedDate());
        System.out.println("Private Message Sent Date: " + privateMessage.getSentDate());
        System.out.println("Private Message Received Date: " + privateMessage.getReceivedDate());
        System.out.println("Private Message Status: " + privateMessage.getMessageStatus());
        System.out.println("Private Message Text:" + privateMessage.getText());
        System.out.println("*******************************************");

        try {
            messageService.addMessage(privateMessage);
            String id = request.getParameter("recipient");
            String message = "Your Private Message was successfully delivered to Recipient with ID = " + id;
            model.addAttribute("message", message);
            return "mailService/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "mailService/sendMailError";
        }
    }
    /************************** End of the Private Message Service *************************/
}
