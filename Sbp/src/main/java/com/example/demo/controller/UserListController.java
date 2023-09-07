package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserService;
import com.example.demo.domain.MUser;
import com.example.demo.form.UserListForm;

@Controller
@RequestMapping("/user")
public class UserListController {

	// get the userlist page
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper ;

	@GetMapping("/list")
	public String getUserList(@ModelAttribute UserListForm form,Model model) {
		// get all user from database, and add to attribute model
		MUser muser = modelMapper.map(form, MUser.class);
		List<MUser> musers = userService.getAllUsers(muser);
		model.addAttribute("musers", musers);
		
		return "user/list";
	}
	
	//post for list
	@PostMapping("/list")
	public String postUserList(@ModelAttribute UserListForm form,Model model) {
		// get all user from database, and add to attribute model
		MUser muser = modelMapper.map(form, MUser.class);
		System.out.println(muser);
		List<MUser> musers = userService.getAllUsers(muser);
		model.addAttribute("musers", musers);
		System.out.println(musers);
		return "user/list";
	}

}
