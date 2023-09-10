package com.example.demo.application.service;

import java.util.List;

import com.example.demo.domain.MUser;

//create a userservice interface ,we do not use any annotation
public interface UserService {

	public void singup(MUser muser);

	public List<MUser> getAllUsers(MUser muser);

	public MUser getUserByuserId(String userId);
	
	public void deleteUserByuserId(String userId);
	
	//update username and password  by userId
	public void updateUserOne(String userId,String userName,String password);
	
	
	public MUser getLoginByuserId(String userId);

}
