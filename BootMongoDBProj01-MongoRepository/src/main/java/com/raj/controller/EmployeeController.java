package com.raj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.raj.document.Employee;
import com.raj.service.IEmployeeService;
@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;

	public String saveEmployee(Employee emp) {
		
		return empService.saveEmployee(emp);
	}

	public Iterable<Employee> showAllEmployees() {
		
		return empService.showAllEmployees();
	}

	public String showEmployeeById(String id) {
		
		return empService.showEmployeeById(id);
	}

	public String updateEmployeeSalary(String id, Double hikePercent) {
		
		return empService.updateEmployeeSalary(id, hikePercent);
	}

}
