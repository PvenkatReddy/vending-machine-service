package com.learning.vending.client.service;

import java.util.List;

import com.learning.vending.client.form.UserTransactionForm;
import com.learning.vending.client.model.Bucket;
import com.learning.vending.client.model.Coin;
import com.learning.vending.client.model.Product;

public interface CustomerService {
	
	public List<Product> getProducts();
	
	public Bucket<Product, List<Coin>> dispatch(UserTransactionForm userTransactionForm);
}
