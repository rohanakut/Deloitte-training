package com.example.boot.boot.demo1.controller;

public class Student {

	int id;
	String name;
	
	
	public Student() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
