package com.learning.vending.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.learning.vending.client.common.Password;
import com.learning.vending.client.jdbcdao.UserDao;
import com.learning.vending.client.model.User;
import com.learning.vending.client.service.SignInService;

public class SignInServiceImpl implements SignInService{

	@Autowired
	UserDao signInDao;
	
	@Override
	@Transactional
	public boolean getUser(User user) {
		User dbUser = signInDao.getUser(user.getUserName(), user.getEmail());
		if(dbUser != null && Password.match(dbUser, user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
