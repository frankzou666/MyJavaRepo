package com.example.demo.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void singup(MUser muser) {
		muser.setDepartmentId(1);
		muser.setRole("ROLE_GENERAL");
		
		//encrypt password 
		String rawPassword = muser.getPassword();
		muser.setPassword(encoder.encode(rawPassword));
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
		String enctyptPassword = encoder.encode(password);
		userMapper.updateOne(userId, userName, enctyptPassword);

	}

	@Override
	public MUser getLoginByuserId(String userId) {
		// TODO Auto-generated method stub
		
		MUser user = userMapper.getOneMuser(userId);
		/*
		 * if (userId.equals("aa@162.com")) { throw new
		 * RuntimeException("you are been locked!"); }
		 */
		return user;
		
	}

}
