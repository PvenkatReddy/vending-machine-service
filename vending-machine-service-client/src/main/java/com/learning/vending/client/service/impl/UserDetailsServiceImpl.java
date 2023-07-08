package com.learning.vending.client.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.vending.client.jdbcdao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDao userInfoDAO;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		com.learning.vending.client.model.User userInfo = userInfoDAO.getUser(userName, null);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getType().name());
		return new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));
	}

}
