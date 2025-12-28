package com.raj.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.document.Employee;
import com.raj.repository.IEmployeeRepository;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepo;
	
	@Override
	public String saveEmployee(Employee emp) {
		
		String idVal = employeeRepo.save(emp).getId();
		return "Employee Document is saved with id value: "+idVal;
	}

	@Override
	public Iterable<Employee> showAllEmployees() {
		
		return employeeRepo.findAll();
	}

	@Override
	public String showEmployeeById(String id) {
		
		Optional<Employee> byId = employeeRepo.findById(id);
		
		if(byId.isPresent()) {
			return  byId.get().toString();
			
		}else {
		   return "Employee not found.";
		}
	}

	@Override
	public String updateEmployeeSalary(String id, Double hikePercent) {
		
		Optional<Employee> byId = employeeRepo.findById(id);
		
		if(byId.isPresent()) {
			Employee emp = byId.get();
			emp.setSalary(emp.getSalary()+emp.getSalary()*hikePercent/100.0);
			employeeRepo.save(emp);
			
			return "Employee Salary is updated.";
		}
		return "Employee is not found.";
	}

}
