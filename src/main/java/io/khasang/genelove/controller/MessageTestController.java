package io.khasang.genelove.controller;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/myMessages")
public class MessageTestController {

    @Autowired
    UserService userService;

    private User currentUser;

    private void init (User currentUser, Model model) {
        currentUser.setUser(userService.getUserByLogin(SecurityContextHolder.getContext()
                .getAuthentication().getName()));
        model.addAttribute("currentUser", currentUser);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView myMesages(Model model){
        currentUser = new User();
        init(currentUser, model);
        ModelAndView modelAndView=new ModelAndView("messages");
        List<String> name=new ArrayList<>();
        name.add("Ivan");
        name.add("Oleg");
        name.add("Nadia");
        name.add("Diana");
        name.add("Marina");
        name.add("Roman");
        modelAndView.addObject("messageList", name);
        modelAndView.addObject("currentUser", currentUser);
        return modelAndView;
    }

}
