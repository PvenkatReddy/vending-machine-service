package com.learning.vending.jdbcdaoimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.util.StringUtils;

import com.learning.vending.exception.VendingMachineUserDataException;
import com.learning.vending.jdbcdao.UserDao;
import com.learning.vending.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public User getUser(String userName, String email) {
		System.out.println("getUser");
		if(!StringUtils.hasLength(userName) && !StringUtils.hasLength(email)) {
			throw new VendingMachineUserDataException("Username/email is empty");
		} 	

		String sql = "select * from user where ";
		
		String parameter = email;
		if(StringUtils.hasLength(userName)) {
			sql = sql+" userName=?";
			parameter = userName;
		} else {
			sql = sql+" email=?";
		}
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), parameter); 
	}
	
	@Override
	public int createUser(User user) {
		
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		
		simpleInsert.withTableName("USER").usingGeneratedKeyColumns("id");
		
		Number id = simpleInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(user));
		
		return id.intValue();
		
	}

}
