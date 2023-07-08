package com.learning.vending.resource.server.jdbcdao;

import com.learning.vending.resource.server.model.User;

public interface UserDao {

	public User getUser(String userName, String email);
	
	public int createUser(User user);
	
}
