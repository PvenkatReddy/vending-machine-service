package com.learning.vending.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.learning.vending.client.common.Password;
import com.learning.vending.client.jdbcdao.UserDao;
import com.learning.vending.client.model.User;
import com.learning.vending.client.service.SignUpService;

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
