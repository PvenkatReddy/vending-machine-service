package com.learning.vending.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.vending.dao.VendingMachineJdbcDao;
import com.learning.vending.model.Product;

public class VendingMachineJdbcDaoImpl implements VendingMachineJdbcDao {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public List<Product> getProducts() {
		
		return jdbc.queryForList("select * from products", Product.class);
		
		
	}

}
