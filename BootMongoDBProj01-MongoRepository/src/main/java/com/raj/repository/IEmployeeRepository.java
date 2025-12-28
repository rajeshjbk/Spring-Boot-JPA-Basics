package com.raj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.raj.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, String> {

}
