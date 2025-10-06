package com.banking.banking_system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.banking_system.models.User;
import com.banking.banking_system.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User registerUser(User user) {
		
		
		
		
		if(user.getRole() == null) user.setRole("USER");
		
		return userRepository.save(user);
	}
	
	public Optional<User> getUserByUsername(String username){
		return userRepository.findByUsername(username);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
}
