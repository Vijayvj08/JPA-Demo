package com.example.FirstAPI.controller.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String greet() {
		return "Hello world";
	}

	public HelloService() {
		System.out.println("Service object created....");
	}
}
