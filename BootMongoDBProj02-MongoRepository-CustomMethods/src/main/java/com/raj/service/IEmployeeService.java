package com.raj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raj.document.Employee;

@Service
public interface IEmployeeService {

     public List<Employee> showEmployeesByAddrs(List<String> cities);
     
     public List<Employee> showEmployeesBySalaryRange(Double start, Double end);
     
     public List<Object[]> fetchEmployeesDataByAddrs(String addrs);
     public List<Employee> fetchEmployeesAddrs(String addrs);
     
}
