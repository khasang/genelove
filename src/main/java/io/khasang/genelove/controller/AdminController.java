package io.khasang.genelove.controller;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller(value = "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/admin/usersList", method = RequestMethod.GET)
    public String allQuestion(Model model) {
        List<User> usersList = adminService.getUsersList();
        long allUsersCount = adminService.getAllUsersCount();
        model.addAttribute("usersList", usersList);
        model.addAttribute("allUsersCount", allUsersCount);
        return "usersList";
    }

//    @RequestMapping(value = "/blockUser/{name}", method = RequestMethod.GET)
//    public ModelAndView hello(@PathVariable("name") String name) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("encode");
//        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
//        return modelAndView;
//    }
}
