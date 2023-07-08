package com.learning.vending.oauth.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.vending.oauth.server.jdbcdao.*;
import com.learning.vending.oauth.server.jdbcdao.impl.UserDaoImpl;

@Configuration
public class VendingMachineOauthServerConfiguration {
	
	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}
	
}
