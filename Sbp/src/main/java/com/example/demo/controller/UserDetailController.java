package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserService;
import com.example.demo.domain.MUser;
import com.example.demo.form.UserDetailForm;

@Controller
@RequestMapping("/user")
public class UserDetailController {

	// get the userlist page
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/detail/{userId:.+}")
	public String getUserByuserId(@PathVariable("userId") String userId, UserDetailForm userDetailForm, Model model) {
		// get all user from database, and add to attribute model
		MUser muser = userService.getUserByuserId(userId);
		userDetailForm = modelMapper.map(muser, UserDetailForm.class);
		model.addAttribute("userDetailForm", userDetailForm);
		return "user/detail";
	}
	
	@PostMapping(value="/detail",params={"update"})
	public String upserUserByuserId( UserDetailForm userDetailForm, Model model) {
		// get all user from database, and add to attribute model
	
		userService.updateUserOne(
				userDetailForm.getUserId(),
				userDetailForm.getUserName(),
				userDetailForm.getPassword()	
				);
		return "redirect:/user/list";
	}
	
	@PostMapping(value="/detail",params={"delete"})
	public String deleteUserByuserId( UserDetailForm userDetailForm, Model model) {
		// get all user from database, and add to attribute model
	
		userService.deleteUserByuserId(userDetailForm.getUserId());
		System.out.println(userDetailForm);
		return "redirect:/user/list";
	}

}
