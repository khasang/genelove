package io.khasang.genelove.controller;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/admin/usersList", method = RequestMethod.GET)
    public String allQuestion(Model model) {
        List<User> usersList = adminService.getUsers();
        long allUsersCount = adminService.getAllUsersCount();
        model.addAttribute("usersList", usersList);
        model.addAttribute("allUsersCount", allUsersCount);
        return "usersList";
    }
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String users(Model model){
        model.addAttribute("users", adminService.getUsers());
        return "users";
    }

    @RequestMapping(value = "user/id/{id}", method = RequestMethod.GET)
    public String userById(@PathVariable("id") int id, Model model){
        model.addAttribute("users", adminService.getUserById(id));
        return "users";
    }

    @RequestMapping(value = "user/login/{login}", method = RequestMethod.GET)
    public String userByLogin(@PathVariable("login") String login, Model model){
        model.addAttribute("users", adminService.getUserByLogin(login));
        return "users";
    }

    @RequestMapping(value = "delete/id/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteUser(@RequestBody User user, HttpServletResponse response){
        try {
            adminService.deleteUser(user);
            return "User deleted successfully";
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error deleting user: " + e.getMessage();
        }
    }
}
