package com.learning.vending.jdbcdao;

import java.util.List;


import com.learning.vending.model.Product;

public interface VendingMachineDao {
	
	public List<Product> getProducts();

}
