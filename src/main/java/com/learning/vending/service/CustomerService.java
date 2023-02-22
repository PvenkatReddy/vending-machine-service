package com.learning.vending.service;

import java.util.List;

import com.learning.vending.form.UserTransactionForm;
import com.learning.vending.model.Bucket;
import com.learning.vending.model.Coin;
import com.learning.vending.model.Product;

public interface CustomerService {
	
	public List<Product> getProducts();
	
	public Bucket<Product, List<Coin>> dispatch(UserTransactionForm userTransactionForm);
}
