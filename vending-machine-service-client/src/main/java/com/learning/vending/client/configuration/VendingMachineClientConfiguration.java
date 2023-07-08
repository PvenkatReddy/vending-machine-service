package com.learning.vending.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.learning.vending.client.jdbcdao.CoinDao;
import com.learning.vending.client.jdbcdao.ProductDao;
import com.learning.vending.client.jdbcdao.UserDao;
import com.learning.vending.client.jdbcdao.UserTransactionDao;
import com.learning.vending.client.jdbcdao.impl.CoinDaoImpl;
import com.learning.vending.client.jdbcdao.impl.ProductDaoImpl;
import com.learning.vending.client.jdbcdao.impl.UserDaoImpl;
import com.learning.vending.client.jdbcdao.impl.UserTransactionDaoImpl;
import com.learning.vending.client.service.CustomerService;
import com.learning.vending.client.service.SignInService;
import com.learning.vending.client.service.SignUpService;
import com.learning.vending.client.service.impl.CustomerServiceImpl;
import com.learning.vending.client.service.impl.SignInServiceImpl;
import com.learning.vending.client.service.impl.SignUpServiceImpl;
import com.learning.vending.client.service.impl.UserDetailsServiceImpl;

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
