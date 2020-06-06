package com.jp.covid19.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jp.covid19.constants.Constant;

@Controller
public class LoginController {
	
    @GetMapping("/login")
    public String login() {
        return Constant.LOGIN_PAGE;
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
