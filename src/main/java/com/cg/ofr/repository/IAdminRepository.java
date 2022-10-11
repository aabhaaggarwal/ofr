package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByEmail(String email);

}
