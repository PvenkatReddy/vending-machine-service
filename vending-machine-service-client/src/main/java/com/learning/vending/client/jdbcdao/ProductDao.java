package com.learning.vending.client.jdbcdao;

import java.util.List;

import com.learning.vending.client.model.Product;

public interface ProductDao {
	
	public List<Product> getProducts();
	
	public Product getProduct(String string, boolean forUpdate);

	public int updateProduct(Product product);
}
