package com.example.JPADemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.JPADemo.controller.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	List<Student> findByTechnology(String technology);
	
	@Query(nativeQuery = true,
			value = "SELECT * FROM student WHERE gender =:gender AND technology =:technology")
	List<Student> findByStudentsByGenderAndTechnology(@Param("gender") String gender,
														@Param("technology") String technology);
}
