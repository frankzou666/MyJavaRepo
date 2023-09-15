package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MUser;

@Mapper
public interface UserMapper {
	// insert a user
	public Integer InsertOne(MUser muser);
	
	//get all user
	public List<MUser> getAllMuser(MUser muser);
	
	//get a user by userId
	public MUser findOne(String userId);
	
	//delete a user by userId
	public Integer DeleteOne(String userId);
	
	//update username and password  by userId
	public void updateOne(String userId,String userName,String enctyptPassword);
	
	//get on user
	public MUser getOneMuser(String userId);

}

