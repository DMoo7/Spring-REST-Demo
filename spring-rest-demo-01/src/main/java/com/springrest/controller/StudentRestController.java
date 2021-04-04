package com.springrest.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.dao.StudentDAO;
import com.springrest.entity.Student;



@RestController
@RequestMapping("/api")
public class StudentRestController 
{

	private StudentDAO studentDAO;
	
@Autowired
public StudentRestController(StudentDAO theStudentDAO)
{
	
	studentDAO = theStudentDAO;
}
	
@GetMapping("/students")
public List<Student> findAll(){
	
	return studentDAO.findAll();
}
	
@GetMapping("/students/{studentId}")
public Student getStudent(@PathVariable int studentId){
	
	
	Student theStudent = studentDAO.findById(studentId);
	
	if(theStudent == null)
	{
		
		throw new RuntimeException("Student id not found - " + studentId);
		
	}
	
	
	return theStudent;
	
		
	}
	
@PostMapping("/students")
public Student addStudent(@RequestBody Student theStudent)
{
	
	theStudent.setId(0);
	
	studentDAO.save(theStudent);
	
	return theStudent;
	
}
	
}
	

