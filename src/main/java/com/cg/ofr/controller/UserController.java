package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.User;
import com.cg.ofr.model.ForgetPasswordRequest;
import com.cg.ofr.model.LoginRequest;
import com.cg.ofr.model.LoginResponse;
import com.cg.ofr.service.IUserService;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private IUserService iUserService;

	
	@PostMapping("/login")
	public ResponseEntity<Object> validatUser(@RequestBody LoginRequest loginRequest) {
		User user = iUserService.validateUser(loginRequest.getUsername(), loginRequest.getPassword(),loginRequest.getRole());
		LoginResponse loginResponse = new LoginResponse();
	    loginResponse.setId(user.getUserId());
	    loginResponse.setUsername(user.getUsername());
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	@PostMapping("/forgetpassword")
	public ResponseEntity<Object> validateEmail(@RequestBody ForgetPasswordRequest passwordRequest) {
		User user = iUserService.validateEmail(passwordRequest.getEmail(),passwordRequest.getRole(),passwordRequest.getPassword());
		LoginResponse loginResponse = new LoginResponse();
	    loginResponse.setId(user.getUserId());
	    loginResponse.setUsername(user.getUsername());
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

}
