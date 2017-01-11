package io.khasang.genelove.controller;

import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.Question;
import io.khasang.genelove.model.*;
import io.khasang.genelove.services.MessageService;
import io.khasang.genelove.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AppController {

    @Autowired
    Contacts contacts;

    @Autowired
    CreateFilm createFilm;

    @Autowired
    CreateRole createRole;

    @Autowired
    TestTable testTable;

    @Autowired
    QuestionService questionService;

    @Autowired
    MessageService messageService;


    @RequestMapping(value = "/manx/createFilm", method = RequestMethod.GET)
    public String createFilms(Model model) {
        model.addAttribute("createFilm", createFilm.createFilmStatus());
        return "createFilm";
    }

    @RequestMapping(value = "/manx/createRole", method = RequestMethod.GET)
    public String createRoles(Model model) {
        model.addAttribute("createRole", createRole.createRoleStatus());
        return "createRole";    }


    @RequestMapping(value = "/manx/insert", method = RequestMethod.GET)
    public String insertInto(Model model) {
        model.addAttribute("insert", testTable.insertTableStatus());
        return "insert";
    }

    @RequestMapping("/joinInner")
    public String joinInner(Model model) {
        model.addAttribute("joinInner", testTable.joinInnerStatus());
        return "joinInner";
    }

    @RequestMapping("/joinFullOuter")
    public String joinFullOuter(Model model) {
        model.addAttribute("joinFullOuter", testTable.joinFullOuterStatus());
        return "joinFullOuter";
    }

    @RequestMapping("/joinRightOuter")
    public String joinRightOuter(Model model) {
        model.addAttribute("joinRightOuter", testTable.joinRightOuterStatus());
        return "joinRightOuter";
    }

    @RequestMapping("/case")
    public String caseTable(Model model) {
        model.addAttribute("caseTable", testTable.caseTableStatus());
        return "case";
    }

    @RequestMapping("/select")
    public String select(Model model) {
        model.addAttribute("select", testTable.selectTableStatus());
        return "select";
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

    @RequestMapping(value = "/db/addMessage", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object addMessage(@RequestBody Message message, HttpServletResponse response) {
        try {
            messageService.addMessage(message);
            return message;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding message: " + e.getMessage();
        }

    }
}
