package com.spia.spia02;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get ;

@WebMvcTest(com.spia.spia02.controller.Hello.class)

public class HelloControllerTest {
	
      @Autowired
	  private MockMvc mockMvc;
      
      
      @Test
      public void testHome() throws Exception {
    	  mockMvc.perform(get("/home"))
    	         .andExpect(status().isOk())
    	         .andExpect(content().string(containsString("welcome to springA")))
    	  ;
      }
}
