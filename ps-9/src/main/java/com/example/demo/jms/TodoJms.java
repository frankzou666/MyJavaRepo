package com.example.demo.jms;

import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Ps9Application;

import ch.qos.logback.classic.Logger;

@Service
@Component
public class TodoJms {
	private final Logger logger =  (Logger)LoggerFactory.getLogger(TodoJms.class);
	private JmsTemplate jmsTemplate;
	public TodoJms(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	
	}
	public void sendMessage(String destination, String str) {
		// send message
		jmsTemplate.convertAndSend(destination,str);
		logger.info("send message to : "+destination+"-"+str);
	}
	

}
