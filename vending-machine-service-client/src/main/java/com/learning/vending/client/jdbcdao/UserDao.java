package com.learning.vending.client.jdbcdao;

import com.learning.vending.client.model.User;

public interface UserDao {

	public User getUser(String userName, String email);
	
	public int createUser(User user);
	
}
