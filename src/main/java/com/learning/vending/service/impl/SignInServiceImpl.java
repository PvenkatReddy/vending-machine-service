package com.learning.vending.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.learning.vending.common.Password;
import com.learning.vending.jdbcdao.UserDao;
import com.learning.vending.model.User;
import com.learning.vending.service.SignInService;

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
