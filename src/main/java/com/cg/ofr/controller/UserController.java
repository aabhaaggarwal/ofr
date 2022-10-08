package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.model.LoginResponse;
import com.cg.ofr.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;

	@GetMapping("/tenant/{username}/{password}")
	public ResponseEntity<Object> validateTenant(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		Tenant tenant = iUserService.validateTenant(username, password);
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setId(tenant.getUserId());
		loginResponse.setName(tenant.getTenantName());
		return new ResponseEntity<>(loginResponse, HttpStatus.OK);

	}

	@GetMapping("/landlord/{username}/{password}")
	public ResponseEntity<Object> validateLandlord(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		Landlord landlord = iUserService.validateLandlord(username, password);
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setName(landlord.getLandlordName());
		loginResponse.setId(landlord.getUserId());
		return new ResponseEntity<>(landlord, HttpStatus.OK);

	}

	@GetMapping("/tenant/email/{email}")
	public ResponseEntity<Object> forgetPasswordTenant(@PathVariable("email") String email) {
		Tenant tenant = iUserService.forgetPasswordTenant(email);
		return new ResponseEntity<>(tenant, HttpStatus.OK);
	}

	@GetMapping("/landlord/email/{email}")
	public ResponseEntity<Object> forgetPasswordLandlord(@PathVariable("email") String email) {
		Landlord landlord = iUserService.forgetPasswordLandlord(email);
		return new ResponseEntity<>(landlord, HttpStatus.OK);
	}

}
