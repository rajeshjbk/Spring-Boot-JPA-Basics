package com.raj.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Employee;
import com.raj.service.IEmployeeMgmtService;

@Component
public class EmployeeMgmtTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService empMgmtService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("\n========== Employee Management System ==========");
				
				System.out.println("1. Register New Employee.");
				System.out.println("2. Show All Employees.");
				System.out.println("3. Calculate Age of Specific Employee.");
				System.out.println("4. Exit.");
				
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Employee Name: ");
					String name = sc.nextLine();
					
					System.out.print("Enter Employee Address: ");
					String address = sc.nextLine();
					
					System.out.print("Enter Date of Birth(yyyy-MM-dd): ");
					LocalDate dob = LocalDate.parse(sc.nextLine());
					
					System.out.print("Enter Time of Birth(HH:mm:ss): ");
					LocalTime tob = LocalTime.parse(sc.nextLine());
					
					System.out.print("Enter Joining Date And Time(yyyy-MM-ddTHH:mm:ss): ");
					LocalDateTime doj = LocalDateTime.parse(sc.nextLine());
					
					Employee emp = new Employee(name, address, dob, tob, doj);
					
					String registerEmployee = empMgmtService.registerEmployee(emp);
					System.out.println(registerEmployee);
					break;
					
				case 2:
					
					empMgmtService.showEmployee().forEach(System.out::println);
					break;
				case 3:
					System.out.print("Enter Employee ENO: ");
					int eno = Integer.parseInt(sc.nextLine());
					
					double calculateAgeById = empMgmtService.calculateAgeById(eno);
					System.out.println("Employee Age: "+calculateAgeById);
					break;
				case 4:
					System.exit(0);
				default:
					System.err.println("Invalid Choice...");
				}
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
