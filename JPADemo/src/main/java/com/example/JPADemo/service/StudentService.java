package com.example.JPADemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPADemo.controller.model.Student;
import com.example.JPADemo.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo repo;
	
	public List<Student> getAllStudents(){
		return repo.findAll();
	}

	public void addStudent(Student student) {
		repo.save(student);
		
	}

	public Student getStudentByRno(int rno) {
		return repo.findById(rno).orElse(new Student());
	}


	public void updateStudent(Student student) {
		repo.save(student);	
	}

	public void deleteStudentByRno(int rno) {
		repo.deleteById(rno);
		
	}

	public void clearStudents() {
		repo.deleteAll();
		
	}

	public List<Student> getStudentsByTechnology(String technology) {
		return repo.findByTechnology(technology);
	}

	public List<Student> getStudentsByGenderAndTechnology(String gender, String technology) {
		return repo.findByStudentsByGenderAndTechnology(gender, technology);
	}
}
