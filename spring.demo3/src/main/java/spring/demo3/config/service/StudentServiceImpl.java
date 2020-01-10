package spring.demo3.config.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo3.config.dao.StudentDao;
import spring.demo3.config.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@PostConstruct
	private void init()
	{
		System.out.println("Student Data object class created");
	}
	
	@PreDestroy
	private void destroy()
	{
		System.out.println("Student Data object class destroyed");
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public void create(Student s) {
		// TODO Auto-generated method stub
		studentDao.create(s);
	}

}
