package io.khasang.genelove.controller;

import io.khasang.genelove.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //(value = "/account")
@RequestMapping(value = "/account")
public class UserController {
    @Autowired
    UserModel user;

    @RequestMapping(value = "/")
    public String test () {
        return "accountTest";
    }

    @RequestMapping(value = "/account/info", method = RequestMethod.GET)
    public String userInfo (Model userModel) {
        userModel.addAttribute("userInfo", user.userInfoStatus());
        return "userInfo";
    }
}
