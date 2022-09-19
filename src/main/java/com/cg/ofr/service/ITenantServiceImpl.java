package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;

@Service
public class ITenantServiceImpl implements ITenantService {

	@Autowired
	private ITenantRepository iTenantRepository;

	@Override
	public Tenant addTenant(Tenant tenant) {
		Tenant newTenant = iTenantRepository.save(tenant);
		return newTenant;
	}

	@Override
	public Tenant updateTenant(Tenant tenant) throws TenantNotFoundException {

		Optional<Tenant> optionalTenant = iTenantRepository.findById(tenant.getUserId());
		if (optionalTenant.isEmpty()) {
			throw new TenantNotFoundException("Tenant not existing with id: " + tenant.getUserId());
		}
		Tenant updatedTenant = iTenantRepository.save(tenant);
		return updatedTenant;
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
		Tenant tenant = optionalTenant.get();
		return tenant;
	}

	@Override
	public List<Tenant> viewAllTenant() {
		List<Tenant> tenants = iTenantRepository.findAll();
		return tenants;

	}
}
