package io.khasang.genelove.controller;

import io.khasang.genelove.entity.Role;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;

@Controller
@RequestMapping("/admin")
@Secured(value = "ROLE_ADMIN")
public class AdminController {

    @Autowired
    AdminService adminService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Role.class, new PropertyEditorSupport() {
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
    public String usersList(@RequestParam(value = "similarLogin", required = false) final String similarLogin,
                            @RequestParam(value = "page", required = false, defaultValue = "1") final String page,
                            Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("usersList", adminService.getUsersPage(similarLogin,Integer.parseInt(page)));
        model.addAttribute("allUsersCount", adminService.getAllUsersCount());
        return "admin/usersList";
    }*/

    @RequestMapping(value = "usersList", method = RequestMethod.GET)
    public String usersList(@RequestParam(value = "page", required = false) String page,
                            @RequestParam(value = "filter", required = false) String filter,
                            Model model) {

        PagedListHolder myList = null;

        if (filter == null) {
            myList = new PagedListHolder(adminService.getUsers());
        }
        else {
            myList = new PagedListHolder(adminService.filterUsers(filter));
        }

        myList.setPageSize(4);

        if (page != null) {
            if ("previous".equals(page)) {
                myList.previousPage();
            } else if ("next".equals(page)) {
                myList.nextPage();
            }
        }

        model.addAttribute("user", new User());
        model.addAttribute("usersList", myList);
        model.addAttribute("allUsersCount", adminService.getAllUsersCount());
        return "admin/usersList";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String userNew(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/addUser";
    }

    @RequestMapping(value = "user/id/{id}", method = RequestMethod.GET)
    public String userById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", adminService.getUserById(id));
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/updateUser";
    }

    @RequestMapping(value = "user/login/{login}", method = RequestMethod.GET)
    public String userByLogin(@PathVariable("login") String login, Model model){
        model.addAttribute("user", adminService.getUserByLogin(login));
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/updateUser";
    }

/*    @RequestMapping(value = "submit", method = RequestMethod.GET)
    @ResponseBody
    public String submit(@ModelAttribute("user") User user){

        return "admin/update";
    }*/

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object addUser(@ModelAttribute(value = "user") User user, HttpServletResponse response) {
        try {
            if (user != null) {
                adminService.addUser(user);
                return "User " + user.getLogin() + " added successfully";
            }
            else {
                return "User not found";
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding user: " + e.getMessage();
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateUser(@ModelAttribute(value = "user") User user, HttpServletResponse response) {
        try {
            if (user != null) {
                adminService.updateUser(user);
                return "User updated successfully";
            }
            else {
                return "User not found";
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error updating user: " + e.getMessage();
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
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
    }

    @RequestMapping(value = "promote", method = RequestMethod.POST)
    @ResponseBody
    public Object promoteUser(@ModelAttribute("user") User user){
        try {
            Role role = adminService.getRoleByName(Role.RoleName.ROLE_ADMIN);

            if (adminService.checkUserRole(user, role)) {
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
            Role role = adminService.getRoleByName(Role.RoleName.ROLE_BLOCKED);

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
