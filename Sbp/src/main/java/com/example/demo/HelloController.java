


package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@PostMapping("/hello")
	public String putHello(@RequestParam("text1") String text1,Model model) {
		model.addAttribute("text1",text1);
		return "hello/response";
	}
	
	@PostMapping("/hello/db")
	public String findById(@RequestParam("employeeid") String id,Model model) {
		//get from service
		Employee employee = helloService.getEmployee(id);
		//set model attribute
		model.addAttribute("employee",employee);
		return "hello/db";
	}

}
