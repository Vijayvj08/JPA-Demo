package com.banking.banking_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.banking_system.models.User;
import com.banking.banking_system.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user){
		return ResponseEntity.ok(userService.registerUser(user));
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable String username){
		return ResponseEntity.ok(userService.getUserByUsername(username));
						  
	}
	
	@GetMapping("/getusers")
	public List<User> getUsers(){
		return userService.getUsers();
	}
}
