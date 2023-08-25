package com.example.demo.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	private String userId;
	private String userName;
	private String password = TestEnum.A;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	private Integer age;
	private Integer gender;

}
