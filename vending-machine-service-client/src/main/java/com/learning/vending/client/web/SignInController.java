package com.learning.vending.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.vending.client.exception.VendingMachineUserDataException;
import com.learning.vending.client.model.User;
import com.learning.vending.client.service.SignInService;


@RestController
@RequestMapping("/vendingmachine")
public class SignInController {

	@Autowired
	SignInService signInService;
	
	@PostMapping("/signin")
	public ResponseEntity<String> signinUser(@RequestBody User user){
		if(user != null) {
			if(!StringUtils.hasLength(user.getUserName())) {
				throw new VendingMachineUserDataException("Username is empty");
			}
			boolean found = signInService.getUser(user);
			if(found)
				return new ResponseEntity<>("User is authenticated successfully", HttpStatus.ACCEPTED);
			else {
				return new ResponseEntity<>("Unauthorised", HttpStatus.UNAUTHORIZED);
			}
		} else {
			return new ResponseEntity<>("User name/password is empty", HttpStatus.BAD_REQUEST);
		}
	}
	
}
