package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.service.CustomUserDetailsService;
import com.service.StudentService;

@RestController
@RequestMapping("/private")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	

	
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		
		return studentService.getStudent(id);
	}

	@GetMapping("/get")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/super")
	public String getSuperData()
	{
		return "This is accessible to admin only......";
	}
	
	
}
