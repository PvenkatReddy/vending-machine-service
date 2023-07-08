package com.learning.vending.client.form;

import com.learning.vending.client.metadata.CoinEnum;
import com.learning.vending.client.model.UserTransaction;

import lombok.Data;

@Data
public class UserTransactionForm {

	private int quantity;
	
	private String productId;
	
	private CoinEnum coin;
	
	private String userId;
	
	
	public UserTransaction initUserTransaction() {
		UserTransaction userTransaction = new UserTransaction();
		userTransaction.setProductId(productId);
		userTransaction.setQuantity(quantity);
		userTransaction.setInsertedAmount(coin.getPrice());
		userTransaction.setUserId(userId);
		
		return userTransaction;
	}
}
