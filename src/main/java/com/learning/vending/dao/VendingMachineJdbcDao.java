package com.learning.vending.dao;

import java.util.List;


import com.learning.vending.model.Product;

public interface VendingMachineJdbcDao {
	
	public List<Product> getProducts();

}
