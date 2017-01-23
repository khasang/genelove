package io.khasang.genelove.controller;

import io.khasang.genelove.entity.EMail;
import io.khasang.genelove.entity.Role;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.service.AdminService;
import io.khasang.genelove.service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping("/admin")
@Secured(value = "ROLE_ADMIN")
public class AdminController {

    @Autowired
    Environment environment;
    @Autowired
    AdminService adminService;
    @Autowired
    MailSender emailService;

    PagedListHolder myList = new PagedListHolder();

    private void init (AdminService adminService, Model model) {
        Role roleBlocked = adminService.getRoleByName(Role.RoleName.ROLE_BLOCKED);
        Role roleAdmin = adminService.getRoleByName(Role.RoleName.ROLE_ADMIN);
        model.addAttribute("allUsersCount", adminService.getAllUsersCount());
        model.addAttribute("blockedUsersCount", adminService.getAssocRolesCount(roleBlocked));
        model.addAttribute("adminUsersCount", adminService.getAssocRolesCount(roleAdmin));
    }

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
    public String adminScreen(Model model) {
        adminService.createAllRoles();

        model.addAttribute("allUsersCount", adminService.getAllUsersCount());

        Role roleBlocked = adminService.getRoleByName(Role.RoleName.ROLE_BLOCKED);
        model.addAttribute("blockedUsersCount", adminService.getAssocRolesCount(roleBlocked));

        Role roleAdmin = adminService.getRoleByName(Role.RoleName.ROLE_ADMIN);
        model.addAttribute("adminUsersCount", adminService.getAssocRolesCount(roleAdmin));
        return "admin/index";
    }

    @RequestMapping(value = "usersList", method = RequestMethod.GET)
    public String usersList(@RequestParam(value = "page", required = false) String page,
                            @RequestParam(value = "filter", required = false) String filter,
                            Model model) {

        if (filter == null) {
            myList.setSource(adminService.getUsers());
        }
        else {
            myList.setSource(adminService.filterUsers(filter));
        }

        myList.setPageSize(4);

        if (page != null) {
            if ("previous".equals(page)) {
                myList.previousPage();
            } else if ("next".equals(page)) {
                myList.nextPage();
            } else{
                myList.setPage(Integer.parseInt(page));
            }
        }

        model.addAttribute("user", new User());
        model.addAttribute("usersList", myList);
        model.addAttribute("allUsersCount", adminService.getAllUsersCount());

        Role roleBlocked = adminService.getRoleByName(Role.RoleName.ROLE_BLOCKED);
        model.addAttribute("blockedUsersCount", adminService.getAssocRolesCount(roleBlocked));

        Role roleAdmin = adminService.getRoleByName(Role.RoleName.ROLE_ADMIN);
        model.addAttribute("adminUsersCount", adminService.getAssocRolesCount(roleAdmin));
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
    public String userById(@PathVariable("id") int id,
                           @RequestParam(value = "changePassword", required = false) boolean changePassword,
                           Model model){
        User user = adminService.getUserById(id);
        if (changePassword) {
            user.setPassword(null);
        }
        model.addAttribute("user", user);
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/updateUser";
    }

    @RequestMapping(value = "sendMailToUserByMail", method = RequestMethod.POST)
    public String sendMailToUserByMail(HttpServletRequest request, Model model) {
        adminService.createAllRoles();
        init(adminService, model);
        model.addAttribute("mailto", request.getParameter("email"));
        return "admin/sendMailToUserByMail";
    }

    @RequestMapping(value = "sendMail", method = RequestMethod.POST)
    public String sendMail(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        try {
            request.setCharacterEncoding("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        adminService.createAllRoles();
        String footer = "\n\n" + "This mail was sended to you from Administrator of " +
                "Genelove Meeting Service. You don't need to answer on this letter.";
        EMail eMail = new EMail(
                request.getParameter("recipient"),
                environment.getProperty("mail.username"),
                request.getParameter("subject"),
                request.getParameter("message") + footer
        );
        emailService.setEmailFields(eMail);
        try {
            emailService.sendEmail(eMail);
            String message = "Your Mail was successfully delivered to User at address " +
                    request.getParameter("recipient");
            model.addAttribute("message", message);
            return "admin/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "mailService/sendMailError";
        }
    }

    @RequestMapping(value = "user/login/{login}", method = RequestMethod.GET)
    public String userByLogin(@PathVariable("login") String login,
                              @RequestParam(value = "changePassword", required = false)
                              boolean changePassword, Model model) {
        User user = adminService.getUserByLogin(login);
        if (changePassword) {
            user.setPassword(null);
        }
        model.addAttribute("user", user);
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/updateUser";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object addUser(@ModelAttribute(value = "user") User user, HttpServletResponse response) {
        try {
            if (user != null) {
                user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
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
                // Get user details from the database
                User dbUser = adminService.getUserById(user.getId());
                // Check if the password was changed. If yes, encode the new password
                if (!dbUser.getPassword().equals(user.getPassword())) {
                    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
                }
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
