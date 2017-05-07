package com.aricent.cop.webengers.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aricent.cop.webengers.models.Users;
import com.aricent.cop.webengers.repositories.UsersLoginRepository;
import com.aricent.cop.webengers.repositories.UsersMongoRepository;

/**
 * This is the controller class containing custom REST endpoint for user login
 *
 */
@Controller
public class UsersController {

	@Autowired
	UsersMongoRepository usersMongoRepository;
	
	@Autowired
	UsersLoginRepository usersLoginRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Users users) {
		
		String username = users.getUsername();
		String password = users.getPassword();

		Users user = usersLoginRepository.searchUserByUsername(username);
		
		String response;

		if(user == null) {
			response = "Sorry! "+username+" does not exist...";
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} else if(StringUtils.equals(user.getPassword(), password)){
			response = "Welcome "+username+"! You are authorized...";
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response = "Sorry! Unmatched username or password. Not Authorized";
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}
			
		
	}
	
	
}
