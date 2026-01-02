package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Student;

public interface IStudentRepositorty extends JpaRepository<Student, Integer> {

}
