package com.raj.service;

import java.util.List;

import com.raj.entity.Student;

public interface IStudentMgmtService {

	String register(Student student);
	
	Student showStudentById(int id);
	
	List<Student> showAllStudents();
}

