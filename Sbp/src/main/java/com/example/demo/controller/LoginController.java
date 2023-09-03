package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	// get the login page
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}
	
	//why do we redirect user/list in post method
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:user/list";
	}

}
