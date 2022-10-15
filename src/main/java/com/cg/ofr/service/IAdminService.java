package com.cg.ofr.service;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.AdminNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;

public interface IAdminService {
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException;

	public Admin addAdmin(Admin admin) throws AdminNotFoundException;
	
	public Admin viewAdmin(int i) throws AdminNotFoundException;
}
