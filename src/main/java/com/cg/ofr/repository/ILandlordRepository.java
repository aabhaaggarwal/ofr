package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Landlord;

@Repository
public interface ILandlordRepository extends JpaRepository<Landlord,String>{

}
