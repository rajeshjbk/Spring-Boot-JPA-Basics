package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.repository.IFlightDetailsRepository;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IFlightDetailsRepository flightDetailsRepository;
	
	@Override
	public void run(String... args)throws Exception{

		try(Scanner sc = new Scanner(System.in) ){
			
			while(true) {
				
				System.out.println("====== Flight Management System ======");
				System.out.println("1. Find By Type Is.");
				System.out.println("2. Get By Type Equals.");
				System.out.println("3. Read By Type.");
				System.out.println("4. Find By Capacity Between.");
				System.out.println("5. Find By FName Starting With.");
				System.out.println("6. Find By FName Ending With.");
				System.out.println("7. Find By FName Containing.");
				System.out.println("8. Find By FName Equals.");
				System.out.println("9. Find By Company In Order By FName Asc.");
				System.out.println("10. Find By Company Like.");
				System.out.println("11. Find By Capacity Greater Than Equal And Capacity Less Than Equal.");
				System.out.println("12. Find By Capacity Between Or Company In Order By Company Asc.");
				
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Flight type: ");
					String type = sc.nextLine();
					flightDetailsRepository.findByTypeIs(type).forEach(System.out::println);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
					
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					
					break;
				default:
					System.err.println("Invalid Input...");
				}
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
