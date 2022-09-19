package com.cg.ofr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;

	@PutMapping("/tenant/update/user")
	public ResponseEntity<Tenant> modifyTenant(@Valid @RequestBody Tenant tenant) {
		Tenant updateTenant = iUserService.updateTenantPassword(tenant);
		return new ResponseEntity<>(updateTenant, HttpStatus.OK);
		

	}

	@PutMapping("/landlord/update/user")
	public ResponseEntity<Landlord> modifyLandlord(@Valid @RequestBody Landlord landlord) {
		Landlord updateLandlord = iUserService.updateLandlordPassword(landlord);
		return new ResponseEntity<>(updateLandlord, HttpStatus.OK);
		

	}

	@GetMapping("/tenant/{username}/{password}")
	public ResponseEntity<Object> validateTen(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		Tenant tenant = iUserService.validateTenant(username, password);
		return new ResponseEntity<>(tenant, HttpStatus.OK);
		
	}

	@GetMapping("/landlord/{username}/{password}")
	public ResponseEntity<Object> validateLan(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		Landlord landlord = iUserService.validateLandlord(username, password);
		return  new ResponseEntity<>(landlord, HttpStatus.OK);
		
	}

	@PostMapping("/tenant/register")
	public ResponseEntity<Object> register(@Valid @RequestBody Tenant tenant) {
		Tenant newTenant = iUserService.validateNewTenant(tenant);
		return new ResponseEntity<>(newTenant, HttpStatus.OK);
		
	}

	@PostMapping("/landlord/register")
	public ResponseEntity<Object> register(@Valid @RequestBody Landlord landlord) {
		Landlord newLandlord = iUserService.validateNewLandlord(landlord);
		return  new ResponseEntity<>(newLandlord, HttpStatus.OK);
		
	}

}
