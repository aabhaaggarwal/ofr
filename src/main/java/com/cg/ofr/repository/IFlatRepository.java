package com.cg.ofr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.Landlord;

@Repository
public interface IFlatRepository extends JpaRepository<Flat, Integer> {
	@Query("SELECT f FROM Flat f WHERE f.cost >= ?1 and f.cost<= ?2 and f.status='approved'")
	public List<Flat> findByCost(float mincost,float maxcost);
	
	@Query("SELECT f FROM Flat f WHERE f.flatAddress.city = :city and f.status='approved'")
	public List<Flat> findByCity(@Param("city") String city);
	
	@Query("SELECT f FROM Flat f WHERE f.availability = 'available' and f.status='approved'")
	public List<Flat> findByAvailability();
	
	@Query("SELECT f FROM Flat f WHERE f.flatType = ?1 and f.status='approved'")
	public List<Flat> findByType(String type);
	
	public List<Flat> findByStatus(String status);

	public List<Flat> findByLandlord(Landlord landlord);
}
