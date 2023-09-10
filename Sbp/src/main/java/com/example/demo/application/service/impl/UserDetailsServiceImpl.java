package com.example.demo.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.application.service.UserService;
import com.example.demo.domain.MUser;


//interface UserDetailsService 

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		MUser muser = service.getLoginByuserId(username);
		
		GrantedAuthority authoriy = new SimpleGrantedAuthority(muser.getRole());
		List<GrantedAuthority>  authoriys = new ArrayList<>();
		authoriys.add(authoriy);
		
		UserDetails userDetails = (UserDetails) new User(muser.getUserId(),muser.getPassword(),authoriys);
		
		return userDetails;
	}

}
