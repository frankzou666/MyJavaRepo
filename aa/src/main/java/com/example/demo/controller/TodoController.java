package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.TodoRepository;

@RestController
public class TodoController {

	public  TodoController() {
	}
	@RequestMapping("/todos")
	public String getTodos() {
		return "mapping";
	}

}
