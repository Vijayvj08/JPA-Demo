package com.example.SpringSecurity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	List<Student> students = new ArrayList<>(
			Arrays.asList(
					new Student(1,"vijay","CSE"),
					new Student(2,"Sampath","IT")));
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@GetMapping("/")
	public String getSessionId(HttpServletRequest reuest) {
		return reuest.getSession().getId();
	}
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return students;
	}
	
	@PostMapping("/students")
	public void addStudent(@RequestBody Student student) {
		students.add(student);
	}
}
