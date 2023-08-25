package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	// get the login page
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}

}
