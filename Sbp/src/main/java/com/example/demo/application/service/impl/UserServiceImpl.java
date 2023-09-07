package com.example.demo.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.application.service.UserService;
import com.example.demo.domain.MUser;
import com.example.demo.repository.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void singup(MUser muser) {
		muser.setDepartmentId(1);
		muser.setRole("ROLE_GENERAL");
		log.info("add user..." + muser);

		userMapper.InsertOne(muser);

	}

	@Override
	public List<MUser> getAllUsers(MUser muser) {
		// TODO Auto-generated method stub
		return userMapper.getAllMuser(muser);
	}

	// get one user

	@Override
	public MUser getUserByuserId(String userId) {
		// TODO Auto-generated method stub
		return userMapper.findOne(userId);
	}

	
	@Override
	@Transactional
	public void deleteUserByuserId(String userId) {
		// TODO Auto-generated method stub
		int count = userMapper.DeleteOne(userId);

	}

	@Transactional   
	@Override
	public void updateUserOne(String userId, String userName, String password) {
		// TODO Auto-generated method stub
		userMapper.updateOne(userId, userName, password);
		int i=1/0;

	}

}
