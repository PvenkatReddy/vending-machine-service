package com.learning.vending.client.jdbcdao;

import com.learning.vending.client.model.UserTransaction;

public interface UserTransactionDao {

	public int createTransaction(UserTransaction userTransaction);
	
}
