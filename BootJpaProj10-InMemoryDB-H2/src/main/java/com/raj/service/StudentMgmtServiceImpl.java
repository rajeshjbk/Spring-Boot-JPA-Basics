package com.raj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Student;
import com.raj.repository.IStudentRepositorty;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {

	@Autowired
	private IStudentRepositorty studentRepo;
	
	
	@Override
	public String register(Student student) {
		
		Integer sid = studentRepo.save(student).getSid();
		
		return "New Student is registered with SID: "+sid;
	}

	@Override
	public Student showStudentById(int id) {
		
		Student student = studentRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invali SID."));
		return student;
	}

	@Override
	public List<Student> showAllStudents() {
		
		return studentRepo.findAll();
	}

}
