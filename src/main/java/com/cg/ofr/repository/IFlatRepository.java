package com.cg.ofr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Flat;

@Repository
public interface IFlatRepository extends JpaRepository<Flat, Integer> {
	@Query("SELECT f FROM Flat f WHERE f.cost >= ?1 and f.cost<= ?2")
	public List<Flat> findByCost(float mincost,float maxcost);
	
	@Query("SELECT f FROM Flat f WHERE f.flatAddress.city = :city")
	public List<Flat> findByCity(@Param("city") String city);
	
	@Query("SELECT f FROM Flat f WHERE f.availability = 'available'")
	public List<Flat> findByAvailability();
	
	@Query("SELECT f FROM Flat f WHERE f.flatType = ?1")
	public List<Flat> findByType(String type);
}
