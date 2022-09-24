package com.cg.ofr.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.service.ITenantService;

@RestController
public class TenantController {

	@Autowired
	private ITenantService iTenantService;

	@PostMapping("/tenant/save")
	public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {

		Tenant newTenant = iTenantService.addTenant(tenant);
		return new ResponseEntity<>(newTenant, HttpStatus.CREATED);

	}

	@PutMapping("/tenant/update")
	public ResponseEntity<Tenant> modifyTenant(@RequestBody Tenant tenant) {
		Tenant updatedTenant = iTenantService.updateTenant(tenant);
		return new ResponseEntity<>(updatedTenant, HttpStatus.OK);

	}

	@DeleteMapping("/tenant/{tId}")
	public ResponseEntity<String> deleteTenantById(@PathVariable("tId") int TenantId) {

		iTenantService.deleteTenant(TenantId);
		return new ResponseEntity<>("Tenant Deleted Successfully!!", HttpStatus.OK);
	}

	@GetMapping("tenant/all")
	public List<Tenant> fetchAllTenant() {
		return iTenantService.viewAllTenant();
	}

	@GetMapping("/tenant/{tId}")
	public ResponseEntity<Object> fetchTenantById(@PathVariable("tId") int TenantId) {

		Tenant tenant = iTenantService.viewTenant(TenantId);
	    return new ResponseEntity<>(tenant, HttpStatus.OK);

	}

}
	
	