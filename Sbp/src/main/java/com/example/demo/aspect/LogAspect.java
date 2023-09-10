package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 * **
 *    test asptect of LoginController
 * 
 * 
 */

@Aspect
@Slf4j
@Component
public class LogAspect {
	
	
	//before logincontroller, we log
	@Before("execution(* *..*SignupController.getSignup(..))")
	public void startLog(JoinPoint jp) {
		log.info("start loginController..."+jp.getSignature());
		
	}
	@After("execution(* *..*LoginController.postLogin(..))")
	public void startLogPost(JoinPoint jp) {
		log.info("post start loginController...");
		
	}

}
