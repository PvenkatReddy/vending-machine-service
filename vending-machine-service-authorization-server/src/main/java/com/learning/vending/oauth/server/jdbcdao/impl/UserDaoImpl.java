package com.learning.vending.oauth.server.jdbcdao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.learning.vending.oauth.server.exception.VendingMachineUserDataException;
import com.learning.vending.oauth.server.jdbcdao.UserDao;
import com.learning.vending.oauth.server.model.User;

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
	
}
