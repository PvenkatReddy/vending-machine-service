package com.learning.vending.oauth.server.jdbcdao;

import org.springframework.stereotype.Repository;

import com.learning.vending.oauth.server.model.User;

@Repository
public interface UserDao {

	public User getUser(String userName, String email);
	
}

