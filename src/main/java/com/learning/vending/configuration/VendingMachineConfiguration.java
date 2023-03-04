package com.learning.vending.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.vending.jdbcdao.UserDao;
import com.learning.vending.jdbcdao.UserTransactionDao;
import com.learning.vending.jdbcdao.CoinDao;
import com.learning.vending.jdbcdao.ProductDao;
import com.learning.vending.jdbcdaoimpl.UserDaoImpl;
import com.learning.vending.jdbcdaoimpl.UserTransactionDaoImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.learning.vending.jdbcdaoimpl.CoinDaoImpl;
import com.learning.vending.jdbcdaoimpl.ProductDaoImpl;
import com.learning.vending.service.CustomerService;
import com.learning.vending.service.SignInService;
import com.learning.vending.service.SignUpService;
import com.learning.vending.service.impl.SignInServiceImpl;
import com.learning.vending.service.impl.SignUpServiceImpl;
import com.learning.vending.service.impl.UserDetailsServiceImpl;
import com.learning.vending.service.impl.CustomerServiceImpl;

@Configuration
public class VendingMachineConfiguration {

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
	public UserDao getSignInDao() {
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
