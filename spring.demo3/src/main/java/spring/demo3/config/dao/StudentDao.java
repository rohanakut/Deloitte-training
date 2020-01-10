package spring.demo3.config.dao;

import java.util.List;

import spring.demo3.config.model.Student;

public interface StudentDao {
	
	public List<Student> findAll();
	
	public void create(Student s);

}
