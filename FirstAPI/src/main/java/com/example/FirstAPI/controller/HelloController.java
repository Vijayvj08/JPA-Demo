package com.example.FirstAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstAPI.controller.service.HelloService;

@RestController
public class HelloController {
	
	@Autowired
	HelloService service;
	
	@GetMapping("/")
	public String greet() {
		return service.greet(); 
	}
	
}
