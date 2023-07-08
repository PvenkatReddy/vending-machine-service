package com.learning.vending.resource.server.jdbcdao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.learning.vending.resource.server.jdbcdao.UserTransactionDao;
import com.learning.vending.resource.server.model.UserTransaction;

public class UserTransactionDaoImpl implements UserTransactionDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int createTransaction(UserTransaction userTransaction) {
		
		userTransaction.setStartDate(new Date());
		userTransaction.setEndDate(new Date());
		
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
		
		simpleInsert.withTableName("USER_TRANSACTIONS").usingGeneratedKeyColumns("id");
		
		Number id = simpleInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(userTransaction));
		
		return id.intValue();
		
	}

	
}
