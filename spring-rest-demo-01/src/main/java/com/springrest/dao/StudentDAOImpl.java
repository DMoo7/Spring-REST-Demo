package com.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.entity.Student;


@Repository
public class StudentDAOImpl implements StudentDAO
{

	private EntityManager entityManager;
	
@Autowired
public StudentDAOImpl(EntityManager theEntityManager)
{
	entityManager = theEntityManager;
}
	
@Override
@Transactional
public List<Student> findAll(){
	
	
	Session currentSession = entityManager.unwrap(Session.class);
	
	
	Query<Student> theQuery = currentSession.createQuery(" from Student ",Student.class);
	
	List<Student> students = theQuery.getResultList();
	
	return students;
	
	
}

@Override
public Student findById(int theId)
{
	
	Session currentSession = entityManager.unwrap(Session.class);
	
	Student theStudent = currentSession.get(Student.class,theId);
	
	return theStudent;
	
	
	
}

@Override
@Transactional
public void save(Student theStudent)
{
	
	Session currentSession = entityManager.unwrap(Session.class);
	
	currentSession.saveOrUpdate(theStudent);
	
	
}


}
