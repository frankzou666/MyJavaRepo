package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


public class Sb {
	@Value("${server.port}")
	private   String serverPort;
	public void sayHello() {
		System.out.println("say hello");
		System.out.println(serverPort);
	}
	public Sb() {
		System.out.println("sb class initall");
	}


}
