package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raj.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select datediff(curdate(),dob)/365.25 from Employee_Records where eno=:eno", nativeQuery = true) //for MySQL
//	@Query(value = "select (sysdate-dob)/365.25 from EMPLOYEE_RECORDS where eno=:eno",nativeQuery = true) //for Oracle
	double calculateAgeById(int eno);
}
