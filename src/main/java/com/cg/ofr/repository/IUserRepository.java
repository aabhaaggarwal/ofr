package com.cg.ofr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

}
