package com.learning.vending.resource.server.service;

import java.util.List;

import com.learning.vending.resource.server.form.UserTransactionForm;
import com.learning.vending.resource.server.model.Bucket;
import com.learning.vending.resource.server.model.Coin;
import com.learning.vending.resource.server.model.Product;


public interface CustomerService {
	
	public List<Product> getProducts();
	
	public Bucket<Product, List<Coin>> dispatch(UserTransactionForm userTransactionForm);
}
