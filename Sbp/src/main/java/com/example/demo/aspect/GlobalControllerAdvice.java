package com.example.demo.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex,Model model) {
		model.addAttribute("error","allinternalerror");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		return "error/allerror";
		
	}

}
