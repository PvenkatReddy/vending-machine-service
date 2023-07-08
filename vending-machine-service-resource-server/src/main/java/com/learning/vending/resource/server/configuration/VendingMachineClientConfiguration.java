package com.learning.vending.resource.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.learning.vending.resource.server.jdbcdao.CoinDao;
import com.learning.vending.resource.server.jdbcdao.ProductDao;
import com.learning.vending.resource.server.jdbcdao.UserDao;
import com.learning.vending.resource.server.jdbcdao.UserTransactionDao;
import com.learning.vending.resource.server.jdbcdao.impl.CoinDaoImpl;
import com.learning.vending.resource.server.jdbcdao.impl.ProductDaoImpl;
import com.learning.vending.resource.server.jdbcdao.impl.UserDaoImpl;
import com.learning.vending.resource.server.jdbcdao.impl.UserTransactionDaoImpl;
import com.learning.vending.resource.server.service.CustomerService;
import com.learning.vending.resource.server.service.SignInService;
import com.learning.vending.resource.server.service.SignUpService;
import com.learning.vending.resource.server.service.impl.CustomerServiceImpl;
import com.learning.vending.resource.server.service.impl.SignInServiceImpl;
import com.learning.vending.resource.server.service.impl.SignUpServiceImpl;
import com.learning.vending.resource.server.service.impl.UserDetailsServiceImpl;

@Configuration
public class VendingMachineClientConfiguration {

	@Bean
	public CustomerService getCustomerService() {
		return new CustomerServiceImpl();
	}
	
	@Bean
	public ProductDao getProductDao() {
		return new ProductDaoImpl();
	}
	
	@Bean
	public SignUpService getSigUpService() {
		return new SignUpServiceImpl();
	}
	
	@Bean
	public SignInService getSigInService() {
		return new SignInServiceImpl();
	}
	
	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public UserTransactionDao getUserTransactionDao() {
		return new UserTransactionDaoImpl();
	}
	
	@Bean
	public CoinDao getCoinDao() {
		return new CoinDaoImpl();
	}
	
//    @Bean
//    public UserDetailsService getUserDetailsService(){
//		return new UserDetailsServiceImpl();
//	}
}
