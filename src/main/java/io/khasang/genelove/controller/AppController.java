package io.khasang.genelove.controller;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {

    @Autowired
    UserService userService;

    /**
     * Root access - Redirect to the home page
     * @return
     */
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String homePage() {
        //userService.update(); // to be removed
        return "redirect:/home";
    }

    /**
     * User registration
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("registerUser") User user,
                               RedirectAttributes redirectAttributes) {
        String message;
        String login = user.getLogin();
        try {
            userService.getUserByLogin(login);
            return "User with login name " + login + " already exists, please try another name!";
        } catch (Exception e) {
            message = "Registration error " + e.getMessage();
        }
        try {
            userService.addUser(user);
            userService.addAuthorisation(user);
            message = "User " + user.getLogin() + " successfully registered.";
        } catch (Exception e) {
            message = "Registration error " + e.getMessage();
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/home";
    }

    /**
     * User login
     */
    @RequestMapping(value = {"/login"})
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }
        model.setViewName("login");
        return model;
    }

}


