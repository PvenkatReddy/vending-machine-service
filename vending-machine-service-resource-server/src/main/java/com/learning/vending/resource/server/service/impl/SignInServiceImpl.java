package com.learning.vending.resource.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.learning.vending.resource.server.common.Password;
import com.learning.vending.resource.server.jdbcdao.UserDao;
import com.learning.vending.resource.server.model.User;
import com.learning.vending.resource.server.service.SignInService;

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
