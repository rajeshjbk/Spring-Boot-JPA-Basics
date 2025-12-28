package com.raj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.raj.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, String> {

	//=================These are find methods================
	public List<Employee> findByeAddIn(List<String> cities);
	
	public List<Employee> findBySalaryBetween(Double start, Double end);
	
	//================These are query methods================ 
//	@Query(value = "{eAdd:?0}", fields = "{eName:1,eAdd:1}")
	@Query(value = "{eAdd:?0}", fields = "{id:0,eName:1,eAdd:1}")
	public List<Object[]> showEmployeeDataByAddrs(String addres);
	
	@Query(value = "{eAdd:?0}", fields = "{}")
	public List<Employee> showEmployees(String addres);
}
