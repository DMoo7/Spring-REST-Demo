package com.springrest.dao;

import java.util.List;

import com.springrest.entity.Student;

public interface StudentDAO 
{

	List<Student> findAll();

	Student findById(int theId);

	void save(Student theStudent);

	
}
