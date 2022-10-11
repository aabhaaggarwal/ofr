package com.cg.ofr.service;

import com.cg.ofr.entities.Admin;

import com.cg.ofr.exception.AdminNotFoundException;

public interface IAdminService {
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException;

	public Admin addAdmin(Admin admin) throws AdminNotFoundException;
}
