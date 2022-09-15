package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Flat;

@Repository
public interface IFlatRepository extends JpaRepository<Flat,String>{

}
