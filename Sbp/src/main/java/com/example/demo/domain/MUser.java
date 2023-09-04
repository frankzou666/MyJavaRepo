package com.example.demo.domain;

import java.util.Date;

import lombok.*;

@Data
@NoArgsConstructor

//define muser
public class MUser {
	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private Integer age;
	private Integer gender;
	private Integer departmentId;
	private String  role;
	
	
	
	

}
