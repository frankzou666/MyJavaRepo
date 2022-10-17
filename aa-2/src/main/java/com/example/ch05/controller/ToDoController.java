package com.example.ch05.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ch05.domain.ToDo;
import com.example.ch05.repository.ToDoRepository;

@RestController
public class ToDoController {
	@Autowired
	private ToDoRepository repository;
	private final Logger log = LoggerFactory.getLogger(ToDoController.class) ;
	@GetMapping("/todo")
	public ResponseEntity<Iterable<ToDo>> getToDos(){
		log.info("request income from ");
	    return ResponseEntity.ok(repository.findAll());
	}
}
