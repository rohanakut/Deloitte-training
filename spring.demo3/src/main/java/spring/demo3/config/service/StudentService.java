package spring.demo3.config.service;

import java.util.List;

import spring.demo3.config.model.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public void create(Student s);

}
