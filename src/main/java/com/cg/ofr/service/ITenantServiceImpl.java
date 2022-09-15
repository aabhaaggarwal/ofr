package com.cg.ofr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;

@Service
public class ITenantServiceImpl implements ITenantService{
	
	@Autowired
	private ITenantRepository iTenantRepository;

	@Override
	public Tenant addTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tenant updateTenant(Tenant tenant) throws TenantNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tenant deleteTenant(Tenant tenant) throws TenantNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tenant viewTenant(String id) throws TenantNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tenant> viewAllTenant() {
		// TODO Auto-generated method stub
		return null;
	}

}
