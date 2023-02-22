package com.learning.vending.jdbcdao;

import com.learning.vending.model.UserTransaction;

public interface UserTransactionDao {

	public int createTransaction(UserTransaction userTransaction);
	
}
