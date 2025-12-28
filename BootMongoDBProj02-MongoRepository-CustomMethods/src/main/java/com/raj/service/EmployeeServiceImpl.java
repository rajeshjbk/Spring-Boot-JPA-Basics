package com.raj.service;

import java.util.List;
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
	public List<Employee> showEmployeesByAddrs(List<String> cities) {
		
		return employeeRepo.findByeAddIn(cities);
	}

	@Override
	public List<Employee> showEmployeesBySalaryRange(Double start, Double end) {
		
		return employeeRepo.findBySalaryBetween(start, end);
	}

	@Override
	public List<Object[]> fetchEmployeesDataByAddrs(String addrs) {

		return employeeRepo.showEmployeeDataByAddrs(addrs);
	}

	@Override
	public List<Employee> fetchEmployeesAddrs(String addrs) {
		
		return employeeRepo.showEmployees(addrs);
	}
	
}
