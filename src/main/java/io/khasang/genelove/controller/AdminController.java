package io.khasang.genelove.controller;

import io.khasang.genelove.entity.EMail;
import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.Role;
import io.khasang.genelove.entity.User;
import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.Utils;
import io.khasang.genelove.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;
    @Autowired
    UserInspectionService userInspectionService;
    @Autowired
    CreateTable createTable;

    PagedListHolder usersList = new PagedListHolder();

    // Set current logged in user to the model
    private void setCurrentUser(Model model) {
        User currentUser = userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());

        model.addAttribute("currentUser", currentUser);
    }

    // Set user statistics to the model
    private void setUserStatistics(Model model) {
        Role roleBlocked = adminService.getRoleByName(Role.RoleName.ROLE_BLOCKED);
        Role roleAdmin = adminService.getRoleByName(Role.RoleName.ROLE_ADMIN);
        model.addAttribute("allUsersCount", adminService.getAllUsersCount());
        model.addAttribute("blockedUsersCount", adminService.getAssocRolesCount(roleBlocked));
        model.addAttribute("adminUsersCount", adminService.getAssocRolesCount(roleAdmin));
    }

    // Bind role text in the dropdown list to Role object
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

    // Service method: get encrypted password for a user (name = login)
    @RequestMapping(value = {"encode/{name}"}, method = RequestMethod.GET)
    public ModelAndView encode(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("testViews/encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
    }

    // Home page
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String adminScreen(Model model) {
        adminService.createAllRoles();
        setCurrentUser(model);
        setUserStatistics(model);
        return "admin/index";
    }

    // List of users
    @RequestMapping(value = "usersList", method = RequestMethod.GET)
    public String usersList(@RequestParam(value = "page", required = false) String page,
                            @RequestParam(value = "filter", required = false) String filter,
                            Model model) {

        setCurrentUser(model);
        setUserStatistics(model);

        if (filter == null) {
            usersList.setSource(adminService.getUsers());
        }
        else {
            usersList.setSource(adminService.filterUsers(filter));
        }

        model.addAttribute("user", new User());
        model.addAttribute("usersList", Utils.paginateList(usersList, page, 4, model));

        return "admin/usersList";
    }

    // New user form
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String userNew(Model model) {
        setCurrentUser(model);
        model.addAttribute("user", new User());
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/addUser";
    }

    // Existing user form
    @RequestMapping(value = "user/id/{id}", method = RequestMethod.GET)
      public String userById(@PathVariable("id") long id,
                           @RequestParam(value = "changePassword", required = false) boolean changePassword,
                           Model model){
        setCurrentUser(model);
        User user = adminService.getUserById(id);
        if (changePassword) {
            user.setPassword(null);
        }
        model.addAttribute("user", user);
        model.addAttribute("accountStatusList", User.getAccountStatusList());
        model.addAttribute("roleList", adminService.getRoles());
        return "admin/updateUser";
    }

    // User maintenance: add new user
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

    // User maintenance: update user
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

    // User maintenance: delete user
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

    // User maintenance: add/remove admin role to the user
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

    // User maintenance: add/remove blocked role to the user
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

    // User inspection service
    @RequestMapping(value = "inspectUser", method = RequestMethod.POST)
    @ResponseBody
    public Object inspectUser(@ModelAttribute("user") User user, HttpServletResponse response) {
        try {
            User dbUser = adminService.getUserById(user.getId());
            userInspectionService.sendInspection(dbUser);

            return "JMS Message for inspection user was send";
        } catch (Exception e) {
            return "Error in inspectionUser method: " + e.getMessage();
        }
    }

    // Messaging service: all methods below
    @RequestMapping(value = "sendMessageToUserById", method = RequestMethod.POST)
    public String sendMessageToUserByMail(HttpServletRequest request, Model model) {
        setCurrentUser(model);
        model.addAttribute("receiver", request.getParameter("receiver"));
        return "admin/sendMessageToUserById";
    }

    @RequestMapping(value = "sendMessage", method = RequestMethod.POST)
    public String sendMessage(HttpServletRequest request, Model model)
            throws UnsupportedEncodingException {
        setCurrentUser(model);

        request.setCharacterEncoding("UTF8");
        String message = request.getParameter("message");
        String option = request.getParameter("option");
        int receiver_id = Integer.parseInt(request.getParameter("receiver"));

        Message privateMessage = new Message(
                userService.getUserByLogin(SecurityContextHolder
                        .getContext().getAuthentication().getName()),
                userService.getUserById(receiver_id), message
        );

        if (option != null) privateMessage.setMessageStatus(Message.MessageStatus.NEW);
        else privateMessage.setMessageStatus(Message.MessageStatus.SENT);

         try {
            messageService.addMessage(privateMessage);
            String service = "Private Message";
             String response = "Your " + service + " was successfully delivered to User " +
                     "by Id <strong>" + request.getParameter("receiver") +"</strong>";
                model.addAttribute("response", response);
             model.addAttribute("service", service);
             return "admin/sendMailResult";
            } catch (Exception exception) {
                model.addAttribute("errorMessage", exception);
             return "mailService/sendMailError";
        }
    }

    @RequestMapping(value = "sendMailToUserByMail", method = RequestMethod.POST)
    public String sendMailToUserByMail(HttpServletRequest request, Model model) {
        setCurrentUser(model);

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
        setCurrentUser(model);
        String footer = "\n\n" + "This mail has been send to you from Administrator of " +
                "Genelove Meeting Service. You don't need to answer on this letter.";
        EMail eMail = new EMail(
                request.getParameter("receiver"),
                environment.getProperty("mail.username"),
                request.getParameter("subject"),
                request.getParameter("message") + footer
        );
        emailService.setEmailFields(eMail);
        try {
            emailService.sendEmail(eMail);
            String service = "e-Mail";
            String response = "Your " + service + " was successfully delivered to User " +
                    "at address <strong>" + request.getParameter("receiver") +"</strong>";
            model.addAttribute("service", service);
            model.addAttribute("response", response);
            return "admin/sendMailResult";
        } catch (Exception exception) {
            model.addAttribute("errorMessage", exception);
            return "mailService/sendMailError";
        }
    }

    //to check
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createTable(Model model) {
        model.addAttribute("create", createTable.createTableStatus());
        return "create";
    }

}
