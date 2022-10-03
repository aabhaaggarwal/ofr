package com.cg.ofr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Admin;

import com.cg.ofr.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService iAdminService;

	@GetMapping("/{username}/{password}")
	public ResponseEntity<Object> validateAdmin(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		Admin admin = iAdminService.validateAdmin(username, password);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Admin> modifyAdmin(@RequestBody Admin admin) {
		Admin updateAdmin = iAdminService.updateAdmin(admin);
		return new ResponseEntity<>(updateAdmin, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
		Admin newAdmin = iAdminService.addAdmin(admin);
		return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<Object> forgetPassword(@PathVariable("email") String email) {
		Admin admin = iAdminService.forgetPassword(email);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
}

