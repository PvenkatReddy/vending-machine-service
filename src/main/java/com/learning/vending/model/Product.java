package com.learning.vending.model;

import com.learning.vending.metadata.ProductType;

import lombok.Data;

@Data
public class Product {

	private int id;
	
	private String name;
	
	private int price;
	
	private int count;
	
	private ProductType type;
	
}
