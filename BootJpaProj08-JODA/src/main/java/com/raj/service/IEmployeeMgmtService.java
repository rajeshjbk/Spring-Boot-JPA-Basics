package com.raj.service;

import java.util.List;

import com.raj.entity.Employee;

public interface IEmployeeMgmtService {

	String registerEmployee(Employee employee);
	
	List<Employee> showEmployee();
	
	double calculateAgeById(int eno);
}
