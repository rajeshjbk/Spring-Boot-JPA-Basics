package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Student;
import com.raj.service.IStudentMgmtService;

@Component
public class InMemoryTestRunner implements CommandLineRunner {

	@Autowired
	private IStudentMgmtService studService;
	
	@Override
	public void run(String... args) throws Exception {
		
        try(Scanner sc = new Scanner(System.in) ){
        	
        	while(true) {
        		System.out.println("========== Student Management System ============");
        		System.out.println("1. Register New Student.");
        		System.out.println("2. Get Student Data by SID.");
        		System.out.println("3. View All Students Data.");
        		System.out.println("4. Exit.");
        		
        		System.out.print("Enter Your Choice: ");
        		int choice = Integer.parseInt(sc.nextLine());
        		
        		switch(choice) {
        		
        		case 1:
        			System.out.print("Enter Student name: ");
        			String name = sc.nextLine();
        			
        			System.out.print("Enter Student Address: ");
        			String addrs = sc.nextLine();
        			
        			System.out.print("Enter Student Average Marks: ");
        			Float avg = Float.parseFloat(sc.nextLine());
        			
        			Student student =  new Student(name, addrs, avg);
        			
        			String register = studService.register(student);
        			System.out.println(register);
        			break;
        			
        		case 2:
        			System.out.print("Enter SID: ");
        			int sid = Integer.parseInt(sc.nextLine());
        			
        			Student showStudentById = studService.showStudentById(sid);
        			System.out.println(showStudentById);
        			break;
        		
        		case 3:
        			studService.showAllStudents().forEach(System.out::println);
        			break;
        		case 4:
        			System.exit(0);
        		}
        	}
        }catch (Exception e) {
			
        	e.printStackTrace();
		}
	}

}
