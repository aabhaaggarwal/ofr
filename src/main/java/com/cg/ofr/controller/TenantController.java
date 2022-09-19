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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.service.ITenantService;

@RestController
@RequestMapping("/tenant")
public class TenantController {

	@Autowired
	private ITenantService iTenantService;

	@PostMapping("/save")
	public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {

		Tenant newTenant = iTenantService.addTenant(tenant);
		ResponseEntity<Tenant> responseEntity = new ResponseEntity<>(newTenant, HttpStatus.CREATED);
		return responseEntity;

	}

	@PutMapping("/update")
	public ResponseEntity<Tenant> modifyTenant(@RequestBody Tenant tenant) {
		Tenant updatedTenant = iTenantService.updateTenant(tenant);
		ResponseEntity<Tenant> responseEntity = new ResponseEntity<>(updatedTenant, HttpStatus.OK);
		return responseEntity;

	}

	@DeleteMapping("/{tId}")
	public ResponseEntity<String> deleteTenantById(@PathVariable("tId") String TenantId) {

		iTenantService.deleteTenant(TenantId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Tenant Deleted Successfully!!", HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/all")
	public List<Tenant> fetchAllTenant() {
		List<Tenant> tenants = iTenantService.viewAllTenant();
		return tenants;
	}

	@GetMapping("/{tId}")
	public ResponseEntity<Object> fetchTenantById(@PathVariable("tId") String TenantId) {

		Tenant tenant = iTenantService.viewTenant(TenantId);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(tenant, HttpStatus.OK);
		return responseEntity;

	}

}
	
	