package com.raj.runners;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.FlightDetails;
import com.raj.service.IFlightMnmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IFlightMnmtService flightMnmtService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				System.out.println("\n====== Flight Management System =======");
				System.out.println("1. Insert One Flight Details: ");
				System.out.println("2. Insert More than one Flight Details: ");
				System.out.println("3. Check Flight is Availabality.");
				System.out.println("4. View All Flights.");
				System.out.println("5. Exit");
				
				System.out.print("\nEnter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					
					System.out.print("Enter Flight Name: ");
					String fName=sc.nextLine();
					
					System.out.print("Enter Company: ");
					String company = sc.nextLine();
					
					System.out.print("Enter Type: ");
					String type = sc.nextLine();
					
					System.out.print("Enter capacity: ");
					Integer capacity = Integer.parseInt(sc.nextLine());
					
					FlightDetails detail = new FlightDetails(fName, company, type, capacity);
					
					String msg = flightMnmtService.saveDetail(detail);
					System.out.println(msg);
					break;
					
				case 2:	
					System.out.print("Enter numbers of flight details you want to saved: ");
					int nosOfFlight = Integer.parseInt(sc.nextLine());
					
					List<FlightDetails> list = new ArrayList<>();
					
					for(int i=1; i<=nosOfFlight; i++) {
						
						System.out.println("\nEnter "+i +" Flight Details");
						
						System.out.print("Enter Flight Name: ");
						fName=sc.nextLine();
						
						System.out.print("Enter Company: ");
						company = sc.nextLine();
						
						System.out.print("Enter Type: ");
						type = sc.nextLine();
						
						System.out.print("Enter capacity: ");
						capacity = Integer.parseInt(sc.nextLine());
						
						detail = new FlightDetails(fName, company, type, capacity);
						
						list.add(detail);
					}
					String registerFlights = flightMnmtService.registerFlights(list);
				    System.out.println(registerFlights);
				    break;
				   
				case 3:
					System.out.print("Enter Flight FNO: ");
					Integer fNo = Integer.parseInt(sc.nextLine());
					boolean flightAvailable = flightMnmtService.isFlightAvailable(fNo);
					System.out.println(flightAvailable?"Flight is Available.":"Flight is not Available.");
					break;
				case 4:
					Iterable<FlightDetails> allFights = flightMnmtService.viewAllFights();
					allFights.forEach(System.out::println);
					break;
				case 5:
					System.exit(0);
				default:
					System.err.println("Invalid Type...");
				}
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
