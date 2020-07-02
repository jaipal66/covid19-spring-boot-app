package com.jp.spring.security.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String allUsersLogin() {
		return "All User Login page";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String userLogin() {
		return "User Login page";
	}

	@RequestMapping(value = "/admins", method = RequestMethod.GET)
	public String adminLogin() {
		return "Admin Login page";
	}
}
