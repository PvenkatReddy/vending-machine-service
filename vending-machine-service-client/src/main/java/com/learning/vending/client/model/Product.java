package com.learning.vending.client.model;

import com.learning.vending.client.metadata.ProductType;

import lombok.Data;

@Data
public class Product {

	private int id;
	
	private String name;
	
	private int price;
	
	private int count;
	
	private ProductType type;
	
}
