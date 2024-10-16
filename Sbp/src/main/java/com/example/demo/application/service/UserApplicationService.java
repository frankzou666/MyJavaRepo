package com.example.demo.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service 
public class UserApplicationService {
	
	// messagesource read messages.propertites
	@Autowired
	private MessageSource messageSource;
	
	public Map<String,Integer> getGenderMap(Locale locale) {
		
		
		
		//define a map ,map the gender to number;
		Map<String,Integer> genderMap = new LinkedHashMap<String,Integer>();
		String male = messageSource.getMessage("male", null, locale);
		String female = messageSource.getMessage("female", null, locale);
		genderMap.put(male, 1);
		genderMap.put(female, 2);
		return genderMap;
		
	}
	

}
