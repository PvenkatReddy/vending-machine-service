package com.learning.vending.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.vending.model.User;
import com.learning.vending.service.SignUpService;

@RestController
@RequestMapping("/vendingmachine")
public class SignupController {

	@Autowired
	SignUpService signUpService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> createUser(@RequestBody  User user){
		
		if(user != null) {
			int id = signUpService.createUser(user);
			
			return new ResponseEntity<>("User is Created "+id, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("User can't be null", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
