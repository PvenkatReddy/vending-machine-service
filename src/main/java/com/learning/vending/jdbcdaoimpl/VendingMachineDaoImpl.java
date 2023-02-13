package com.learning.vending.jdbcdaoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.learning.vending.jdbcdao.VendingMachineDao;
import com.learning.vending.model.Product;

public class VendingMachineDaoImpl implements VendingMachineDao {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public List<Product> getProducts() {
		
		return jdbc.query("select * from products", BeanPropertyRowMapper.newInstance(Product.class));	
		
	}

}
