package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Landlord;

@Repository
public interface ILandlordRepository extends JpaRepository<Landlord, Integer> {

	public Landlord findByUsernameAndPassword(String username, String password);

	public Landlord findByUsername(String username);

	public Landlord findByEmail(String email);

}
