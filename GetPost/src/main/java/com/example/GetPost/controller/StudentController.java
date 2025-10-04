package com.example.GetPost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GetPost.model.Student;
import com.example.GetPost.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@PostMapping("/add/student")
	public void addStudent(@RequestParam("rno") int rno,
							@RequestParam("name") String name,
							@RequestParam("technology") String technology) {
		service.addStudent(rno,name,technology);
	}
}
