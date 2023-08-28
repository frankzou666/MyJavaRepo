package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	@NotBlank
	@Email
	private String userId;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	@Length(min=4,max=10)
	@Pattern(regexp="^[a-z]")
	private String password;
	
    @NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
    
    @Min(10)
    @Max(20)
	private Integer age;
    
    @NotNull
	private Integer gender;

}
