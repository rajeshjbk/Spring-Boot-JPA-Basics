package com.raj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.raj.document.Employee;
import com.raj.service.IEmployeeService;
@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;

	public List<Employee> showEmployeesByAddrs(List<String> cities){
		
		return empService.showEmployeesByAddrs(cities);
	}
    
    public List<Employee> showEmployeesBySalaryRange(Double start, Double end){
    	
    	return empService.showEmployeesBySalaryRange(start, end);
    }
    
    
    public List<Object[]> fetchEmployeesDataByAddrs(String addrs){
    	
    	return empService.fetchEmployeesDataByAddrs(addrs);
    }
    
    public List<Employee> fetchEmployeesAddrs(String addrs){
    	
    	return empService.fetchEmployeesAddrs(addrs);
    }

}
