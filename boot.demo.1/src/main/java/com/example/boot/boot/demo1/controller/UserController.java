package com.example.boot.boot.demo1.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name, Model model) {
		model.addAttribute("user",name);
		return "Hello";
	}
	
	@GetMapping({"/addnum/{num1}/{num2}"})
	public String addnum(@PathVariable long num1, @PathVariable long num2, Model model) {
		model.addAttribute("num1",num1);
		model.addAttribute("num2",num2);
		return "add";
	}
	
	 ArrayList<Student> s = new ArrayList<Student>();
	
	@GetMapping({"/users"})
	public String users(Model model) {
		//Student s1 = new Student(1,"rohan");
		//Student s2 = new Student(2,"rohan1");
		//s.add(s1);
		//s.add(s2);
		model.addAttribute("users",s);
		model.addAttribute("user", new Student());
		return "users";
		
		
	}
	
	@PostMapping("/users")
	public String addUser(Student user) {
		s.add(user);
		return "redirect:/users";
		
	}
}
