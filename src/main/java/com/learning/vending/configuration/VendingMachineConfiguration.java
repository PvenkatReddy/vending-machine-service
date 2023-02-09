package com.learning.vending.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.vending.dao.VendingMachineJdbcDao;
import com.learning.vending.daoimpl.VendingMachineJdbcDaoImpl;
import com.learning.vending.service.MachineService;
import com.learning.vending.service.impl.VendingMachineServiceImpl;

@Configuration
public class VendingMachineConfiguration {

	@Bean
	public MachineService getVendingMachineService() {
		return new VendingMachineServiceImpl();
	}
	
	@Bean
	public VendingMachineJdbcDao getVendingMachineJdbcDao() {
		return new VendingMachineJdbcDaoImpl();
	}
}
