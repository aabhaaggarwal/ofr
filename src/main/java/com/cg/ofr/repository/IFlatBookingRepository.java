package com.cg.ofr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Tenant;

@Repository
public interface IFlatBookingRepository extends JpaRepository<FlatBooking, Integer> {

	public List<FlatBooking> findByTenant(Tenant tenant);

	public List<FlatBooking> findByStatus(String status);
}
