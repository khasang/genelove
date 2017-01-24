package io.khasang.genelove.controller;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.DBLoader;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@Controller
public class DBLoaderController {
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

    private String getCurrentUserName () {
        User currentUser = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        String name = currentUser.getFirstName();
        String lastName = currentUser.getLastName();
        if (name != null && lastName != null)
            return name + " " + lastName;
        else return "Anonymous User";
    }

    /*********************************** DB Loader Service *********************************
    * In this section represents code of Mail Sender Service.
    * Begin of this section here.
    ***************************************************************************************/
    @RequestMapping(value = "/DBLoader", method = RequestMethod.GET)
    public String DBLoader(Model model) {
        model.addAttribute("currentUser", getCurrentUserName());
        String message = "DB Loader is ready";
        model.addAttribute("message", message);
        return "mailService/DBActions";
    }

    @RequestMapping(value = "/clearTables", method = RequestMethod.POST)
    public String clearTables(Model model)
            throws UnsupportedEncodingException {
        model.addAttribute("currentUser", getCurrentUserName());
        String table = "test";
        model.addAttribute("currentUser", getCurrentUserName());
        String message = dbLoader.clearTable(table);
        model.addAttribute("message", message);
        return "mailService/DBActions";
    }

    @RequestMapping(value = "/loadTables", method = RequestMethod.POST)
    public String loadTables(Model model)
            throws UnsupportedEncodingException, FileNotFoundException {
        model.addAttribute("currentUser", getCurrentUserName());
        String path = "/home/alex/khasang/my/genelove/src/main/resources/files/";
        String file = "test.csv";
        String filename = path + file;
        String response = dbLoader.insertFromFile(dbLoader.loadFromFile(filename));
        String message;
        if (response.equals("Ok")) {
            message = "Data were loaded from file <strong>" + filename +
                    "</strong> into table <strong>" +
                    file.substring(0, file.length() - 4) + "</strong>";
            model.addAttribute("message", message);
            return "mailService/DBActions";
        }
        else
            model.addAttribute("errorMessage", response);
        return "mailService/sendMailError";
    }

    @RequestMapping(value = "/viewTables", method = RequestMethod.POST)
    public String viewTables(Model model)
            throws UnsupportedEncodingException, FileNotFoundException {
        model.addAttribute("currentUser", getCurrentUserName());
        String message, response = "";
        if (true) {
            message = "Data were loaded from file <strong>" ;
            model.addAttribute("message", message);
            return "mailService/DBActions";
        }
        else
            model.addAttribute("errorMessage", response);
        return "mailService/sendMailError";
    }
    /*************************** End of the Mail Sender Service ****************************/
}
