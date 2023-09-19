package com.example.demo.controller.rest;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.service.UserService;
import com.example.demo.domain.MUser;
import com.example.demo.form.SignupForm;
import com.example.demo.form.UserDetailForm;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PutMapping("/update")
	public int updateUser(UserDetailForm userDetailForm) {
		userService.updateUserOne(userDetailForm.getUserId()
				                 ,userDetailForm.getUserName()
				                 ,userDetailForm.getPassword()
				                  );
		log.info("update user_id:"+userDetailForm.getUserId() );
		return 0;
		
	}
	
	
	//delete user by id
	@PostMapping("/delete")
	public int deleteUser(UserDetailForm userDetailForm) {
		userService.deleteUserByuserId(userDetailForm.getUserId());
		log.info("delete user_id:"+userDetailForm.getUserId() );
		return 0;
		
	}
	
	@PostMapping("/signup/rest")
	public RestResult signupUser(@Validated SignupForm form,BindingResult bindingResult,Locale locale) {
		// valid error
        if (bindingResult.hasErrors()) {
        	 Map<String,String> errors = new HashMap<>();
        	 for(FieldError error:bindingResult.getFieldErrors()) {
        		 errors.put(error.getField(), error.getDefaultMessage());
        	 }
        	 return new RestResult(90,errors);
        }
		//转换为muser
		MUser muser = modelMapper.map(form, MUser.class);
		
		//调用userService保存用户
		userService.singup(muser);
		//MUser muser 
		
		return new RestResult(0,null);
		
	}

}
