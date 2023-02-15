package com.learning.vending.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.vending.jdbcdao.UserDao;
import com.learning.vending.jdbcdao.SignUpDao;
import com.learning.vending.jdbcdao.VendingMachineDao;
import com.learning.vending.jdbcdaoimpl.UserDaoImpl;
import com.learning.vending.jdbcdaoimpl.SignUpDaoImpl;
import com.learning.vending.jdbcdaoimpl.VendingMachineDaoImpl;
import com.learning.vending.service.MachineService;
import com.learning.vending.service.SignInService;
import com.learning.vending.service.SignUpService;
import com.learning.vending.service.impl.SignInServiceImpl;
import com.learning.vending.service.impl.SignUpServiceImpl;
import com.learning.vending.service.impl.VendingMachineServiceImpl;

@Configuration
public class VendingMachineConfiguration {

	@Bean
	public MachineService getVendingMachineService() {
		return new VendingMachineServiceImpl();
	}
	
	@Bean
	public VendingMachineDao getVendingMachineJdbcDao() {
		return new VendingMachineDaoImpl();
	}
	
	@Bean
	public SignUpService getSigUpService() {
		return new SignUpServiceImpl();
	}
	
	@Bean
	public SignUpDao getSignUpDao() {
		return new SignUpDaoImpl();
	}
	
	@Bean
	public SignInService getSigInService() {
		return new SignInServiceImpl();
	}
	
	@Bean
	public UserDao getSignInDao() {
		return new UserDaoImpl();
	}
}
