package com.example.demo.controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.application.service.UserApplicationService;
import com.example.demo.application.service.UserService;
import com.example.demo.domain.MUser;
import com.example.demo.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller               // controller class
@RequestMapping("/user")  // @RequestMapping as the controller class prefix

@Slf4j
public class SignupController {
	
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/signup")
	
	//@ModelAttribute --spring mvc will population the value to this form
	public String getSignup(Model model,Locale locale,@ModelAttribute SignupForm form) {
		// the get method , get "local" from browser
		//log.info("you access the controller :" + this.getClass().getName());
		Map<String,Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap",genderMap);
		return "user/signup";
		
	}
	
	// add the BindingResult
	
	@PostMapping("/signup")
	public String postSignup(Model model,Locale locale,@ModelAttribute @Validated SignupForm form,BindingResult bindingResult) {
		
		// determation the input validate has error,to getSignup again
		if (bindingResult.hasErrors()) {
			log.info(this.getClass().getName() +" bindingResult errors!");
			return getSignup(model, locale, form);
			
		}	
		
		log.info(form.toString());
		
		// ModelMapper map form to other class
		MUser muser = modelMapper.map(form, MUser.class);
		
		//add user to db
		userService.singup(muser);

		return "redirect:/login";
		
	}

}
