package com.example.demo.controller.rest;





import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor

public class RestResult {
	private int result;
	private Map<String,String> error;
	
	

}
