package com.learning.vending.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.vending.model.Product;
import com.learning.vending.service.MachineService;

@RestController
@RequestMapping("/vendingmachine")
public class VendingMachineController {
	
	@Autowired
	MachineService vendingMachineService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return vendingMachineService.getProducts();
	}
}	
	

