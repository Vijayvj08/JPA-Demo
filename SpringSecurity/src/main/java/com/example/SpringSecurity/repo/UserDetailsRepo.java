package com.example.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurity.model.Users;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users, Integer> {
	Users getByUsername(String username);
}
