package com.raj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Employee;
import com.raj.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository employeeRepo;
	
	@Override
	public String registerEmployee(Employee employee) {
		
		Integer eno = employeeRepo.save(employee).getEno();
		
		return "Employee is saved with ENO: "+eno;
	}

	@Override
	public List<Employee> showEmployee() {
		
		return employeeRepo.findAll();
	}

	@Override
	public double calculateAgeById(int eno) {
		
		return employeeRepo.calculateAgeById(eno);
	}
}
