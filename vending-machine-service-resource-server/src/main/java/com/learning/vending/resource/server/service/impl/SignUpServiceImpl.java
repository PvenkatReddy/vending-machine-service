package com.learning.vending.resource.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.learning.vending.resource.server.common.Password;
import com.learning.vending.resource.server.jdbcdao.UserDao;
import com.learning.vending.resource.server.model.User;
import com.learning.vending.resource.server.service.SignUpService;


public class SignUpServiceImpl implements SignUpService{

	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional
	public int createUser(User user) {
		String hashedPassword = Password.getHashedPassword(user, user.getPassword());
		user.setPassword(hashedPassword);
		return userDao.createUser(user);
	}

}
