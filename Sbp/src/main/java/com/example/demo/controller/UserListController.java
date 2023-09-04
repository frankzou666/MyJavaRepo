package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserService;
import com.example.demo.domain.MUser;

@Controller
@RequestMapping("/user")
public class UserListController {

	// get the userlist page
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String getUserList(Model model) {
		// get all user from database, and add to attribute model
		List<MUser> musers = userService.getAllUsers();
		model.addAttribute("musers", musers);
		return "user/list";
	}

}
