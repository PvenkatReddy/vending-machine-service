package com.learning.vending.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserTransaction {

	private int id;
	
	private String userId;
	
	private String productId;
	
	private Date startDate;
	
	private Date endDate;
	
	private int insertedAmount;
	
	private int returnAmount;
	
	private String status;
	
}
