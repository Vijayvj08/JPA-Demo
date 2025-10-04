package com.example.JPADemo.controller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private int rno;
	private String name;
	private String gender;
	private String technology;
	public Student(int rno, String name, String gender, String technology) {
		super();
		this.rno = rno;
		this.name = name;
		this.gender = gender;
		this.technology = technology;
	}
	public Student(String name, String gender, String technology) {
		super();
		this.name = name;
		this.gender = gender;
		this.technology = technology;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
}
