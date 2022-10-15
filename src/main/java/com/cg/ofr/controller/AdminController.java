package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.service.IAdminService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService iAdminService;

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
	
	@GetMapping("/{aId}")
	public ResponseEntity<Object> fetchAdminById(@PathVariable("aId") int adminId) {

		Admin admin = iAdminService.viewAdmin(adminId);
	    return new ResponseEntity<>(admin, HttpStatus.OK);

	}


}
