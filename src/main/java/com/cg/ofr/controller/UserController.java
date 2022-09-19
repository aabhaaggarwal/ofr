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

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@PutMapping("/tenant/update")
	public ResponseEntity<Tenant> modifyTenant(@RequestBody Tenant tenant) {
		Tenant updateTenant=iUserService.updateTenantPassword(tenant);
		ResponseEntity<Tenant> responseEntity=new ResponseEntity<>(updateTenant,HttpStatus.OK);
		return responseEntity;

}
	@PutMapping("/landlord/update")
	public ResponseEntity<Landlord> modifyLandlord(@RequestBody Landlord landlord) {
		Landlord updateLandlord=iUserService.updateLandlordPassword(landlord);
		ResponseEntity<Landlord> responseEntity=new ResponseEntity<>(updateLandlord,HttpStatus.OK);
		return responseEntity;
		
}
	
	@GetMapping("/tenant/{username}/{password}")
	public ResponseEntity<Object> validateTen(@PathVariable ("username") String username,@PathVariable("password") String password ) {
			Tenant tenant= iUserService.validateTenant( username, password);
			ResponseEntity<Object> responseEntity=new ResponseEntity<>(tenant,HttpStatus.OK);
			return responseEntity;
		}
	
	@GetMapping("/landlord/{username}/{password}")
	public ResponseEntity<Object> validateLan(@PathVariable ("username") String username,@PathVariable("password") String password ) {
			Landlord landlord= iUserService.validateLandlord( username, password);
			ResponseEntity<Object> responseEntity=new ResponseEntity<>(landlord,HttpStatus.OK);
			return responseEntity;
		}
	
	@PostMapping("/tenant/register")
	public ResponseEntity<Object> register(@RequestBody Tenant tenant) {
			Tenant newTenant=iUserService.validateNewTenant(tenant);
			ResponseEntity<Object> responseEntity=new ResponseEntity<>(newTenant,HttpStatus.OK);
			return responseEntity;
		}
	
	@PostMapping("/landlord/register")
	public ResponseEntity<Object> register(@RequestBody Landlord landlord) {
			Landlord newLandlord=iUserService.validateNewLandlord(landlord);
			ResponseEntity<Object> responseEntity=new ResponseEntity<>(newLandlord,HttpStatus.OK);
			return responseEntity;
		}

}
