package com.example.boot.boot.demo1.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@GetMapping("/index")
	public String index() {
		return "Hello";
	}
	
	@GetMapping({"/welcome/{Username}"})
	public String welcome(@PathVariable(name="Username") String name) {
		return "Hello" + name;
	}

	@GetMapping({"/add/{num1}/{num2}"})
	public int add(@PathVariable long num1, @PathVariable long num2) {
		return (int) (num1+num2);
	}
	
	@GetMapping({"/sub/{n1}/{n2}"})
	public int sub(@PathVariable (name="n1") long num1, @PathVariable (name="n2") long num2) {
		return (int) (num1-num2);
	}
	
	@GetMapping({"/compare/{n1}/{n2}"})
	public String compare(@PathVariable (name="n1") String num1, @PathVariable (name="n2") String num2) {
		if(num1.equals(num2))
			return "equal";
		else
			return "not equal";
					
	}
	
	@GetMapping({"/listItems"})
	public ArrayList<Integer> listItems() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(11);
	    numbers.add(3);
		return numbers;			
	}
	
	@GetMapping({"/classprint"})
	public Student classprint() {
		Student s  = new Student(1,"rohan");
		return s;			
	}
}
