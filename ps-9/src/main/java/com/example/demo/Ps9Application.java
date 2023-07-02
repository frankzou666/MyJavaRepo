package com.example.demo;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.jms.TodoJms;

import ch.qos.logback.classic.Logger;


class JmsSend{
	
	@Autowired
    public TodoJms todoJms;
	public void sendTest(String str) {
		System.out.println("####");
		todoJms.sendMessage("q1", str);
	}
	
}

@SpringBootApplication
public class Ps9Application {

	public static void main(String[] args) {
		final Logger logger =  (Logger)LoggerFactory.getLogger(Ps9Application.class);
		SpringApplication.run(Ps9Application.class, args);
		logger.info("my application start...");
		new JmsSend().sendTest("hello jms!");
		
		
	}
	

}
