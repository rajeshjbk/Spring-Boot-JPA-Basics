package com.raj.service;

import org.springframework.stereotype.Service;

import com.raj.document.Employee;

@Service
public interface IEmployeeService {

	String saveEmployee(Employee emp);
	Iterable<Employee> showAllEmployees();
	String showEmployeeById(String id);
	String updateEmployeeSalary(String id, Double hikePercent);
}
