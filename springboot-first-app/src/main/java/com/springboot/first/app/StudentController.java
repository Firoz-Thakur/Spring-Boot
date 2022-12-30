package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping("/student")
	public Student getStudent()
	{
		return new Student("Ramesh","kumar");	
	}

	@RequestMapping("/students")
	public List<Student> getStudents()
	{
		List<Student > students = new ArrayList<>();
		students.add(new Student("firoz", "bhai"));
		students.add(new Student("ajay", "thakur"));
		students.add(new Student("himehs", "kumar"));
		students.add(new Student("baba", "ranjan"));
		students.add(new Student("abhishek", "kumar"));	
		return students;
	}

}
