package com.learning.vending.resource.server.jdbcdao;

import com.learning.vending.resource.server.model.UserTransaction;

public interface UserTransactionDao {

	public int createTransaction(UserTransaction userTransaction);
	
}
