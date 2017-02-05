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

import java.util.List;

@Controller
@RequestMapping(value = "/menuPage")
public class MenuController {
    @Autowired
    UserService userService;

    private User currentUser;

    private void init (User currentUser, Model model) {
        currentUser.setUser(userService.getUserByLogin(SecurityContextHolder.getContext()
                .getAuthentication().getName()));
        model.addAttribute("currentUser", currentUser);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView menuPage(Model model){
        currentUser = new User();
        init(currentUser, model);
        ModelAndView modelAndView=new ModelAndView("menuPage");
        String[] list={"user1","user2","user3","user4","user5","user6","user7","user8"};

        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("list",list);
        return modelAndView;
    }

}
