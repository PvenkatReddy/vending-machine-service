package com.learning.vending.jdbcdaoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.learning.vending.jdbcdao.SignUpDao;
import com.learning.vending.model.User;

public class SignUpDaoImpl implements SignUpDao{

	@Autowired
	JdbcTemplate jdbTemplate;
	
	@Override
	public int createUser(User user) {
		
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbTemplate);

		simpleInsert.withTableName("USER").usingGeneratedKeyColumns("id");
		
		Number id = simpleInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(user));
		
		return id.intValue();
		
	}

	
}
