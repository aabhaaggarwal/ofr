package com.cg.ofr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByUsername(String username);
	public Optional<User> findByEmail(String email);
	public Optional<User> findByEmailAndRole(String email,String role);
}
