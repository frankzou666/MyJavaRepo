package com.example;

import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Ch03Application {
	
	
	public static void main(String[] args) {
		//SpringApplication sp = new SpringApplication(Ch03Application.class);
		// sp.setBannerMode(Banner.Mode.OFF);
		//sp.run(args);
		new SpringApplicationBuilder(Ch03Application.class)
		  .run(args);
		new Ch03Application().getData();
		
	}
	public void getData() {
		System.out.println(myconf.getName());
	}
	
	@Autowired
	Myconf myconf;
	
	
	@Component
	@ConfigurationProperties(prefix="data")
	public static class Myconf {
		public String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}

}
