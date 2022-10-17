package com.example.demo;

import java.io.PrintStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@Component
class MyComponent {
    private static final Logger log = LoggerFactory.getLogger(MyComponent.class);
    @Autowired
    public MyComponent(ApplicationArguments args) {
        boolean enable = args.containsOption("enable");
        if(enable)
            log.info("## > You are enabled!");
        List<String> _args = args.getNonOptionArgs();
        log.info("## > extra args ...");
        if(!_args.isEmpty())
           _args.forEach(file -> log.info(file));
   }
}


@SpringBootApplication
public class StartBoot {
	
	@Autowired
	Sb sb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		SpringApplication sp = new SpringApplication(StartBoot.class);
		sp.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				// TODO Auto-generated method stub
				out.println("my springboot app");
			}
		});
		sp.setBannerMode(Banner.Mode.OFF);
		sp.run(args); */
		
		new SpringApplicationBuilder()
		    .sources(StartBoot.class)
		    .bannerMode(Banner.Mode.OFF)
		    .logStartupInfo(false)
		    .run(args);
		//new StartBoot().sb.sayHello();
		//System.out.println(StartBoot.serverPort);
		
		
	}

}
