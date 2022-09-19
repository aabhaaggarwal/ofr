package com.cg.ofr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Flat;

@Repository
public interface IFlatRepository extends JpaRepository<Flat,String>{
	public List<Flat> findByCostAndAvailability(float cost,String availability);

}
