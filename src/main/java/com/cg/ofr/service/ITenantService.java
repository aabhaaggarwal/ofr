package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;

public interface ITenantService {

	public Tenant addTenant(Tenant tenant) ;
	public Tenant updateTenant(Tenant tenant) throws TenantNotFoundException;
	public Tenant deleteTenant(Tenant tenant) throws TenantNotFoundException;
	public Tenant viewTenant(String id) throws TenantNotFoundException;
	public List<Tenant> viewAllTenant();
	
	//view tenant details by landlord id and flat id 
}
