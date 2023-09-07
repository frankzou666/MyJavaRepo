package com.example.demo.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.domain.Department;
import com.example.demo.domain.Salary;

import lombok.Data;

/**
 * only modify properity
 */

@Data
public class UserDetailForm {

	private String userId;
	
	private String password;

	private String userName;

	private Date birthday;

	private Integer age;

	private Integer gender;
	private Department department;
	private List<Salary> salaryList;

}
