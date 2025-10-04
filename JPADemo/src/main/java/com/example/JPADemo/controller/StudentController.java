package com.example.JPADemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPADemo.controller.model.Student;
import com.example.JPADemo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student student) {
		service.addStudent(student);
		return "Added";
	}
	
	@GetMapping("/students/{rno}")
	public Student getStudentByRno(@PathVariable("rno") int rno) {
		return service.getStudentByRno(rno);
	}
	
	@PutMapping("/students")
	public String updateStudent(@RequestBody Student student) {
		service.updateStudent(student);
		return "updated";
	}
	
	@DeleteMapping("/students/{rno}")
	public String deleteStudent(@PathVariable int rno) {
		service.deleteStudentByRno(rno);
		return "Deleted";
	}
	
	@DeleteMapping("/students/clear")
	public String clearStudents() {
		service.clearStudents();
		return "Cleared all Students";
	}
	
	@GetMapping("/students/technology/{tech}")
	public List<Student> getStudentsByTechnology(@PathVariable("tech") String technology){
		return service.getStudentsByTechnology(technology);
	}
	
	@PostMapping("students/filter")
	public List<Student> getStudentsByGenderAndTechnology(@Param("gender") String gender,
															@Param("technology") String technology){
		
		return service.getStudentsByGenderAndTechnology(gender,technology);
	}
}
