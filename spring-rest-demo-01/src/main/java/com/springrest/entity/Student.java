package com.springrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;

@Column(name="name")
private String name;

@Column(name="dob")
private String dob;

@Column(name="doj")
private String doj;



public Student(){
	super();
	
}


public Student(String name, String dob, String doj) {
	this.name = name;
	this.dob = dob;
	this.doj = doj;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getDob() {
	return dob;
}


public void setDob(String dob) {
	this.dob = dob;
}


public String getDoj() {
	return doj;
}


public void setDoj(String doj) {
	this.doj = doj;
}


@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", doj=" + doj + "]";
}



}


