package com.learning.vending.resource.server.jdbcdao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.util.StringUtils;

import com.learning.vending.resource.server.exception.VendingMachineUserDataException;
import com.learning.vending.resource.server.jdbcdao.UserDao;
import com.learning.vending.resource.server.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public User getUser(String userName, String email) {
		if(!StringUtils.hasLength(userName) && !StringUtils.hasLength(email)) {
			throw new VendingMachineUserDataException("Username/email is empty");
		} 	

		String sql = "select * from users where ";
		
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
		
		simpleInsert.withTableName("USERS").usingGeneratedKeyColumns("id");
		
		Number id = simpleInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(user));
		
		return id.intValue();
		
	}

}
