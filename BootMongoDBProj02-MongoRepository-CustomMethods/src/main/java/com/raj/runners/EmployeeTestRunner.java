package com.raj.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.controller.EmployeeController;
import com.raj.document.Employee;

@Component
public class EmployeeTestRunner implements CommandLineRunner {

	@Autowired
	private EmployeeController empController;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				System.out.println("====== Employee Management System ======");
				System.out.println("1. Show Employees By Address.");
				System.out.println("2. Show Employees By Salary Range.");
				System.out.println("3. Fetch Employees Data By Address.");
				System.out.println("4. Fetch All Employees Address.");
				System.out.println("5. Exit.");
				
				System.out.print("\nEnter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					List<Employee> showEmployeesByAddrs = empController.showEmployeesByAddrs(List.of("Hyd","Dehli"));
					showEmployeesByAddrs.forEach(System.out::println);
					break;
					
				case 2:
					List<Employee> showEmployeesBySalaryRange = empController.showEmployeesBySalaryRange(50000.0, 90000.0);
					showEmployeesBySalaryRange.forEach(System.out::println);
					break;
					
				case 3:
					List<Object[]> fetchEmployeesDataByAddrs = empController.fetchEmployeesDataByAddrs("Hyd");
					fetchEmployeesDataByAddrs.forEach(emp->{
						System.out.println(Arrays.toString(emp));
					});
					break;
					
				case 4:
					List<Employee> fetchEmployeesAddrs = empController.fetchEmployeesAddrs("Noida");				
					fetchEmployeesAddrs.forEach(System.out::println);
					break;
				case 5:
					System.exit(0);
				default:
					System.err.println("Invalid choice...");	
				}
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
