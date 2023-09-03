package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserListController {
   	
	    // get the userlist page
		@GetMapping("/list")
		public String getUserList() {
			return "user/list";
		}

}
