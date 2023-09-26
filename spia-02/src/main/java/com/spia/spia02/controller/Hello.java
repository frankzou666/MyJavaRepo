package com.spia.spia02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Hello {

	  @GetMapping("/home")
	  
	  public String home() {
	    return "ch01/home";
	  }


}
