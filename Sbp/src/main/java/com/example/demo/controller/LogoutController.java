package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LogoutController {
	
	
	// user logout
	@PostMapping("/logout")
	public String postLogin() {
		log.info("User logout...");
		return "redirect:/login";
	}

}
