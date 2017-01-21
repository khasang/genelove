package io.khasang.genelove.controller;

import io.khasang.genelove.entity.EMail;
import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.Question;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.model.AddUsersTemp;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.MyMessage;
import io.khasang.genelove.model.SQLExamples;
import io.khasang.genelove.service.MailSender;
import io.khasang.genelove.service.MessageService;
import io.khasang.genelove.service.QuestionService;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
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
    AddUsersTemp addUsersTemp;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("message", myMessage.getMessage());
        return "hello";
    }

    /** Login user to system" */
    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "loginPage";
    }*/

    /** User registration" */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registrationPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("registerUser") User user,
                               RedirectAttributes redirectAttributes) {
        String message;
        try {
            userService.addUser(user);
            message = "User " + user.getLogin() + " successfully registered.";
        } catch (Exception e) {
            message = "Registration error " + e.getMessage();
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/login";
    }

    /** User ends registration" */
    @RequestMapping(value = "/postRegistration", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object addNewUser(@RequestBody User user, HttpServletResponse response){
        String login = user.getLogin();
        if (userService.getUserByLogin(login)!= null) {
            return "User with login name " + login + " already exists, please try another name!";
        }
        try {
            userService.addUser(user);
            userService.addAuthorisation(user);
            return "You successfully registered!";
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error performing registration: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String createTable(Model model) {
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
    }

    @RequestMapping(value = "/db/addQuestion", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object addQuestion(@RequestBody Question question, HttpServletResponse response) {
        try {
            questionService.addQuestion(question);
            return question;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding question: " + e.getMessage();
        }
    }

    /**
     * Example request http://localhost:8089/db/allQuestion?page=next
     * */
    @RequestMapping(value = "/db/allQuestion", method = RequestMethod.GET)
    public String allQuestion(Model model, @RequestParam(value = "page", required = false) String page) {
        PagedListHolder myList = new PagedListHolder(questionService.getQuestionList());
        myList.setPageSize(4);

        if(page != null) {
            if ("previous".equals(page)) {
                myList.previousPage();
            } else if ("next".equals(page)) {
                myList.nextPage();
            }
        }

        model.addAttribute("allQuestion", myList);
        return "questions";
    }


    @RequestMapping(value = "/db/message/{id}", method = RequestMethod.GET)
    public String getMessageById(@PathVariable("id") int id, Model model) {
        model.addAttribute("message", messageService.getMessageById(id));
        return "message";
    }

    @RequestMapping(value = "/db/messagesAll", method = RequestMethod.GET)
    public String messagesAll(Model model) {
        List<Message> list = messageService.getMessageAll();
        model.addAttribute("messages", list);
        return "messages";
    }

    @RequestMapping("/sql/delete")
    public String delete(Model model) {
        model.addAttribute("delete", sqlExamples.tableDelete());
        return "sql";
    }

    @RequestMapping("/sql/create")
    public String create(Model model) {
        model.addAttribute("create", sqlExamples.tableCreate());
        return "sql";
    }

    @RequestMapping("/sql/insert")
    public String insert(Model model) {
        model.addAttribute("insert", sqlExamples.tableInsert());
        return "sql";
    }

    @RequestMapping("/sql/select")
    public String select(Model model) {
        model.addAttribute("select", sqlExamples.tableSelect());
        return "sql";
    }

    /**
     *********************************** Mail Sender Service. *******************************
     *
     * In this section represents code of Mail Sender Sevice.
     * Begin of this section here.
     ****************************************************************************************
     */
    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public String mailSender() {
        return "emailtest/sendMail";
    }

    @RequestMapping(value = "/insertUsersIntoDB", method = RequestMethod.GET)
    public String addUsersIntoDB(Model model) {
        String response = addUsersTemp.addUsersIntoDB();
        model.addAttribute("message", response);
        if (response.equals("Ok"))
            return "emailtest/sendMailResult";
        else {
            model.addAttribute("errorMessage", response);
            return "emailtest/sendMailError";
        }
    }

    @RequestMapping(value = "/viewAllUsers", method = RequestMethod.GET)
    public String viewAllUsers(Model model) {
        String message = "View all users from our database \"User\"";
        model.addAttribute("message", message);
        model.addAttribute("usersList", userService.getUserAll());
        return "emailtest/viewUsersList";
    }

    @RequestMapping(value = "/viewAllEMails", method = RequestMethod.GET)
    public String viewAllUEMails(Model model) {
        String message = "View all E-Mails";
        model.addAttribute("message", message);
        model.addAttribute("eMailsList", userService.getUserAll());
        return "emailtest/viewEMailsList";
    }

    @RequestMapping(value = "/noAction", method = RequestMethod.POST)
    public String noAction(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        String message = "This is blank for the future usage";
        model.addAttribute("message", message);
        return "emailtest/sendMailResult";
    }

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF8");

        if (request.getParameter("recipient").equals("")) {
            String message = "Recipient's address is null";
            model.addAttribute("errorMessage", message);
            return "emailtest/sendMailError";
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
            return "emailtest/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "emailtest/sendMailError";
        }
    }

    @RequestMapping(value = "/sendMailToAllUsers", method = RequestMethod.GET)
    public String sendMailToAllUsersGET(Model model) {
        String message = "Do you wanna send the message to all users in really?";
        model.addAttribute("message", message);
        return "emailtest/sendMailToAllUsers";
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
            return "emailtest/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "emailtest/sendMailError";
        }
    }


    @RequestMapping(value = "/sendMailById/{id}", method = RequestMethod.GET)
    public String sendMailByIdGET(@PathVariable("id") int id, Model model) {
        String message = "Do you wanna send the message to user (ID = <strong>" +
                id+ "</strong>) in really? ";
        model.addAttribute("message", message);
        model.addAttribute("id", id);
        return "emailtest/sendMailById";
    }

    @RequestMapping(value = "/sendMailById/send", method = RequestMethod.POST)
    public String sendMailByIdPOST(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF8");
        int recipient = Integer.valueOf(request.getParameter("recipient"));
        System.out.println("*************************************************");
        System.out.println("mail: " + emailService.getEmailById(recipient));
        System.out.println("id: " + recipient);
        System.out.println("*************************************************");
        EMail eMail = new EMail(
                //emailService.getEmailById(recipient),
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
            return "emailtest/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "emailtest/sendMailError";
        }
    }

    // Sending e-mail message to client (user)
    @RequestMapping(value = "/sendMailToUser", method = RequestMethod.POST)
    public String doSendEmailToUser(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        //ModelAndView modelAndView = new ModelAndView();

        User user = new User();
        user.setEmail("python239@mail.ru");
        user.setFirstName("Alexander");
        user.setLastName("Pyankov");
        user.setGender("male");

        try {
            emailService.sendEmail(user);
            String message = "Your Mail was successfully delivered to Recipient";
            model.addAttribute("message", message);
            return "emailtest/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "emailtest/sendMailError";
        }
    }

    // Sending e-mail message to client (user)
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
            return "emailtest/sendMailResult";

        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "emailtest/sendMailError";
        }
    }

    //*************************** End of the Mail Sender Service. ***************************


    /**
     ******************************** Private Message Service. ******************************
     *
     * In this section represents code of Mail Sender Seкvice.
     * Finish of this section here.
     ******************************** Private Message Service. *******************************
     */
}
