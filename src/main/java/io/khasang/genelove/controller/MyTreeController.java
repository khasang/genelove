package io.khasang.genelove.controller;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/myProfile")
public class MyTreeController {
    @Autowired
    UserService userService;

    private User currentUser;

    private void init (User currentUser, Model model) {
        currentUser.setUser(userService.getUserByLogin(SecurityContextHolder.getContext()
                .getAuthentication().getName()));
        model.addAttribute("currentUser", currentUser);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView meTreeAcount(Model model){
        currentUser = new User();
        init(currentUser, model);
        ModelAndView modelAndView=new ModelAndView("profile");
        modelAndView.addObject("currentUser", currentUser);
        return modelAndView;
    }
}
