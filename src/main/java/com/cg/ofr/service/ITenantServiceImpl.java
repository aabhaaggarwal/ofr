package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;
import com.cg.ofr.repository.IUserRepository;

@Service
public class ITenantServiceImpl implements ITenantService {

	@Autowired
	private ITenantRepository iTenantRepository;
	
	@Autowired
	private IUserRepository iUserRepository;

	@Override
	public Tenant addTenant(Tenant tenant) {
		Optional<User> user =iUserRepository.findByUsername(tenant.getUsername());
		Optional<User> user1=iUserRepository.findByEmail(tenant.getEmail());
		if(!user.isEmpty()) {
			throw new TenantNotFoundException("This username is not available");
		}
		if(!user1.isEmpty()) {
			throw new TenantNotFoundException("This email is already registered");
		}
		tenant.setRole("tenant");
		return iTenantRepository.save(tenant);
	}

	@Override
	public Tenant updateTenant(Tenant tenant) throws TenantNotFoundException {
		Optional<Tenant> optionalTenant = iTenantRepository.findById(tenant.getUserId());
		if (optionalTenant.isEmpty()) {
			throw new TenantNotFoundException("Tenant not existing with id: " + tenant.getUserId());
		}
		return iTenantRepository.save(tenant);
	}

	@Override
	public void deleteTenant(int tenantId) throws TenantNotFoundException {
		Optional<Tenant> optionalTenant = iTenantRepository.findById(tenantId);
		if (optionalTenant.isEmpty()) {
			throw new TenantNotFoundException("Tenant not existing with id: " + tenantId);
		}
		iTenantRepository.deleteById(tenantId);

	}

	@Override
	public Tenant viewTenant(int id) throws TenantNotFoundException {
		Optional<Tenant> optionalTenant = iTenantRepository.findById(id);
		if (optionalTenant.isEmpty()) {
			throw new TenantNotFoundException("Tenant not existing with id: " + id);
		}
		return optionalTenant.get();
	}

	@Override
	public List<Tenant> viewAllTenant() {
		return iTenantRepository.findAll();

	}
}
