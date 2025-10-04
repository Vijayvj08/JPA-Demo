package com.example.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.model.Users;
import com.example.SpringSecurity.repo.UserDetailsRepo;

@Service
public class MyUserDetailService implements  UserDetailsService{
	
	@Autowired
	UserDetailsRepo userDetailsRepo;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userDetailsRepo.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return null;
	}

}
