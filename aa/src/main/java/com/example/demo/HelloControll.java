package com.example.demo;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControll {
	@Autowired
	public Sb sb;
	@Autowired
	public MyProps myProps;
	@RequestMapping(value="/hello", method=RequestMethod.GET)
    public String hello() {
        sb.sayHello();
		//System.out.println(sb.sayHello());
        SimpleDateFormat sdf =new SimpleDateFormat("Y-M-d H:m:s");
        System.out.println(myProps.getName());
        return sdf.format(System.currentTimeMillis());
    }

}
