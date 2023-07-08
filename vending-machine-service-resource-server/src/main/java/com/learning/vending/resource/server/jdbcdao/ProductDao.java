package com.learning.vending.resource.server.jdbcdao;

import java.util.List;

import com.learning.vending.resource.server.model.Product;

public interface ProductDao {
	
	public List<Product> getProducts();
	
	public Product getProduct(String string, boolean forUpdate);

	public int updateProduct(Product product);
}
