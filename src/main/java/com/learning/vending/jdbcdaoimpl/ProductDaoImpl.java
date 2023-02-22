package com.learning.vending.jdbcdaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.learning.vending.jdbcdao.ProductDao;
import com.learning.vending.model.Product;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Product> getProducts() {
		
		return jdbcTemplate.query("select * from products where count>0", BeanPropertyRowMapper.newInstance(Product.class));	
		
	}

	@Override
	public Product getProduct(String id, boolean forUpdate) {
		String sql = "select * from products where id=?";
		if(forUpdate) {
			sql = sql+" FOR UPDATE";
		}
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Product.class), id);
		
	}

	@Override
	public int updateProduct(Product product) {
	//	KeyHolder keyHolder = new GeneratedKeyHolder();
		return jdbcTemplate.update("update products SET count = ? WHERE id = ?", product.getCount(), product.getId());
//		jdbcTemplate.update(new PreparedStatementCreator() {			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				final PreparedStatement ret = con.prepareStatement("update products SET count = ? WHERE id = ?");
//	            ret.setInt(1, product.getCount());
//	            ret.setInt(2, product.getId());
//	            return ret;
//			}
//		}, keyHolder);
//		return keyHolder.getKey().intValue();
	}

}
