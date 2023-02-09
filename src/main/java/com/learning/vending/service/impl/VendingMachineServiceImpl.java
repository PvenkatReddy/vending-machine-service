package com.learning.vending.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.vending.dao.VendingMachineJdbcDao;
import com.learning.vending.model.Product;
import com.learning.vending.service.MachineService;

public class VendingMachineServiceImpl implements MachineService {
	
	@Autowired
	VendingMachineJdbcDao vendingMachineJdbcDao;

	@Override
	public List<Product> getProducts() {
		return vendingMachineJdbcDao.getProducts();
	}

}
