package com.learning.vending.jdbcdao;

import com.learning.vending.model.User;

public interface UserDao {

	public User getUser(String userName, String email);
	
	public int createUser(User user);
	
}
