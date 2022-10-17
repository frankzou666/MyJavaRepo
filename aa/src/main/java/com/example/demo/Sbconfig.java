package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@Component
public class Sbconfig {
	@Bean
	public Sb sb() {
	  return new Sb();
	}

}

@Component
@ConfigurationProperties(prefix="myapp")
class MyProps{
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;
}