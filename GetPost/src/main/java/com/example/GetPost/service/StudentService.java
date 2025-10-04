package com.example.GetPost.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GetPost.model.Student;

@Service
public class StudentService {
	
	List<Student> students = new ArrayList<>(
			Arrays.asList(new Student(1,"vijay","Java"),
						new Student(2,"sampath","python"),	
						new Student(3,"Arul","BlockChain"))
						);
			
	public List<Student> getAllStudents() {
		return students;
	}

	public void addStudent(int rno, String name, String technology) {
		Student student = new Student(rno,name,technology);
		students.add(student);
	}
	
	
}
