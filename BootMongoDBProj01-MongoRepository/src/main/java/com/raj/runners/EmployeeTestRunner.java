package com.raj.runners;

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
				System.out.println("1. Register new Employee.");
				System.out.println("2. Show all Employees Details.");
				System.out.println("3. Show Employee details by ID.");
				System.out.println("4. Update Employee Salary.");
				System.out.println("5. Exit.");
				
				System.out.print("\nEnter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Employee name: ");
					String name = sc.nextLine();
					System.out.print("Enter Employee Address: ");
					String add = sc.nextLine();
					System.out.print("Enter Employee Salary: ");
					Double sal = Double.parseDouble(sc.nextLine());
					
					Employee emp = new Employee(name, add, sal);
					emp.setCompany("HCL");
					
					String saveEmployee = empController.saveEmployee(emp);
					System.out.println(saveEmployee);
					break;
					
				case 2:
					Iterable<Employee> showAllEmployees = empController.showAllEmployees();
				    showAllEmployees.forEach(System.out::println);
					break;
					
				case 3:
					System.out.print("Enter Employee ID: ");
					String id = sc.nextLine();
					
					String showEmployeeById = empController.showEmployeeById(id);
					System.out.println(showEmployeeById);
					break;
					
				case 4:
					System.out.print("Enter Employee ID: ");
					id = sc.nextLine();
					System.out.print("Enter Employee Salary Hike Percentage: ");
					Double hikePer = Double.parseDouble(sc.nextLine());
					
					String updateEmployeeSalary = empController.updateEmployeeSalary(id, hikePer);
					
					System.out.println(updateEmployeeSalary);
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
