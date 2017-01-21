package io.khasang.genelove.controller;

import io.khasang.genelove.entity.Role;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;

@Controller
@RequestMapping("/admin/")
@Secured(value = "ROLE_ADMIN")
public class AdminController {

    @Autowired
    AdminService adminService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

       /* binder.registerCustomEditor(User.class, new PropertyEditorSupport() {
                    @Override
                    public String getAsText() {
                        Object obj = getValue();
                        if (obj == null) {
                            return null;
                        } else {
                            Role role = (Role) obj;
                            return role.getRoleName().toString();
                        }
                    }

                    @Override
                    public String[] getTags() {
                        String[] tags = new String[Role.RoleName.values().length];
                        for (int i = 0; i < Role.RoleName.values().length; i++) {
                            tags[i] = Role.RoleName.values()[i].toString();
                        }
                        return tags;
                    }
                });*/

        binder.registerCustomEditor(Role.class, new PropertyEditorSupport() {
            /*@Override
            public String getAsText() {
                Object obj = getValue();
                if (obj == null) {
                    return null;
                }
                else {
                    Role role = (Role) obj;
                    return Integer.toString(role.getId());
                }
            };*/

            /*@Override
            public String[] getTags() {
                String[] tags = new String[Role.RoleName.values().length];
                for (int i = 0; i < Role.RoleName.values().length; i++) {
                    tags[i] = Role.RoleName.values()[i].toString();
                }
                return tags;
            }*/

            @Override
            public void setAsText(String text) {
                if (text == null || text.length() == 0) {
                    setValue(null);
                }
                else {
                    setValue(adminService.getRoleById(Integer.parseInt(text)));
                }
            }
        });
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String adminScreen() {
        return "admin/index";
    }

   /* @RequestMapping(value = "usersList", method = RequestMethod.GET)
    public String usersList(Model model) {
    @RequestMapping(value = "usersList", method = RequestMethod.GET)
    public String usersList(@RequestParam(value = "similarLogin", required = false) final String similarLogin,
                            @RequestParam(value = "page", required = false, defaultValue = "1") final String page,
                            Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("usersList", adminService.getUsers(similarLogin,Integer.parseInt(page)));
        model.addAttribute("allUsersCount", adminService.getAllUsersCount());
        return "admin/usersList";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", adminService.getUsers());
        return "admin/users";
    }
    
    /*@RequestMapping(value = "users", method = RequestMethod.GET)
    public String users(Model model){
        model.addAttribute("users", adminService.getUsers());
        return "admin/user";
    }*/

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String userNew(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/user";
    }

    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    @ResponseBody
    public Object saveUser(@ModelAttribute(value = "user") User user, HttpServletResponse response) {
        try {
            adminService.addUser(user);
            return "User added successfully";
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding user: " + e.getMessage();
        }
    }

    @RequestMapping(value = "user/id/{id}", method = RequestMethod.GET)
    public String userById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", adminService.getUserById(id));
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/user";
    }

    @RequestMapping(value = "submit", method = RequestMethod.GET)
    @ResponseBody
    public String submit(@ModelAttribute("user") User user){

        return "admin/update";
    }

    @RequestMapping(value = "user/login/{login}", method = RequestMethod.GET)
    public String userByLogin(@PathVariable("login") String login, Model model){
        model.addAttribute("user", adminService.getUserByLogin(login));
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/user";
    }

   /* @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteUser(@ModelAttribute("user") User user, HttpServletResponse response){
        try {
            if (user != null) {
                adminService.deleteUser(user);
                return "User deleted successfully";
            }
            else {
                return "User not found";
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error deleting user: " + e.getMessage();
        }
    }*/

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteUser(@PathVariable("id") int id, HttpServletResponse response){
        try {
            User user = adminService.getUserById(id);
            if (user != null) {
                adminService.deleteUser(user);
                return "User deleted successfully";
            }
            else {
                return "User not found";
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error deleting user: " + e.getMessage();
        }
    }

    @RequestMapping(value = "promote", method = RequestMethod.POST)
    @ResponseBody
    public Object promoteUser(@ModelAttribute("user") User user){
        try {
            Role role = new Role();
            role.setId(adminService.getRoleId("ROLE_ADMIN"));
            if(adminService.checkUserRole(user, role)) {
                adminService.removeRole(user, role);
                return "User was demoted";
            }
            else {
                adminService.addRole(user, role);
                return "User was successfully promoted to admin";
            }
        } catch (Exception e) {
            return "Error in promoteUser method: " + e.getMessage();
        }
    }

    @RequestMapping(value = "block", method = RequestMethod.POST)
    @ResponseBody
    public Object blockUser(@ModelAttribute("user") User user) {
        try {
            Role role = new Role();
            role.setId(adminService.getRoleId("ROLE_BLOCKED"));

            if (user == null) {
                return "User not found";
            }
            if (adminService.checkUserRole(user, role)) {
                adminService.removeRole(user, role);
                return "User was unblocked";
            }
            else {
                adminService.addRole(user, role);
                return "User was successfully blocked";
            }
        } catch (Exception e) {
            return "Error in blockUser method: " + e.getMessage();
        }
    }
}
