package com.learning.vending.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.learning.vending.dao.VendingMachineJdbcDao;
import com.learning.vending.model.Product;

public class VendingMachineJdbcDaoImpl implements VendingMachineJdbcDao {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public List<Product> getProducts() {
		
		return jdbc.query("select * from products", BeanPropertyRowMapper.newInstance(Product.class));	
		
	}

}
