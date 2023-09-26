package com.spia.spia01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSp {
	
	
	public static void main(String[] args) {
		//
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		Person person = null;
		person = (Person) ctx.getBean("person");
		System.out.println(person.getName());
		
	}

}
