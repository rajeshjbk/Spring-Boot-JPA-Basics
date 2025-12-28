package com.raj.runners;

import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.raj.entity.FlightDetails;
import com.raj.service.FlightMnmtServiceImpl;
import com.raj.service.IFlightMnmtService;

@Component
public class PagingAndSortingRepositoryTestRunner implements CommandLineRunner {

	private final FlightMnmtServiceImpl flightMnmtServiceImpl;

	@Autowired
	private IFlightMnmtService flightMnmtService;

	PagingAndSortingRepositoryTestRunner(FlightMnmtServiceImpl flightMnmtServiceImpl) {
		this.flightMnmtServiceImpl = flightMnmtServiceImpl;
	}

	@Override
	public void run(String... args) throws Exception {

		try(Scanner sc = new Scanner(System.in)){

			while(true) {
				System.out.println("\n====== Flight Management System =======");
				System.out.println("\n1. Show Flights As Sorted.");
				System.out.println("2. Show Flights By PageNo.");
				System.out.println("3. Show Flights By PageNo As Sorted.");
				System.out.println("4. Show Flights By Pagination.");
				System.out.println("5. Exit");

				System.out.print("\nEnter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {

				case 1:
					System.out.print("Enter Flight property which basis you want Sort: ");
					String prop = sc.nextLine();
					System.out.print("Enter Sorting Order, For Ascending(true) / Descending(false): ");
					boolean orderSort = Boolean.parseBoolean(sc.nextLine());
					Iterable<FlightDetails> showFlightsAsSorted = flightMnmtServiceImpl.showFlightsAsSorted(orderSort, prop);
					showFlightsAsSorted.forEach(System.out::println);
					break;
				case 2:
					System.out.print("Enter page size: ");
					int pageSize = Integer.parseInt(sc.nextLine());
					System.out.print("Enter page no: ");
					int pageNo = Integer.parseInt(sc.nextLine());
					
					Page<FlightDetails> showFlightsByPageNo = flightMnmtService.showFlightsByPageNo(pageNo, pageSize);
					showFlightsByPageNo.forEach(System.out::println);
					break;
				case 3:
					System.out.print("Enter page size: ");
					pageSize = Integer.parseInt(sc.nextLine());
					System.out.print("Enter page no: ");
					pageNo = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Flight property which basis you want Sort: ");
					prop = sc.nextLine();
					System.out.print("Enter Sorting Order, For Ascending(true) / Descending(false): ");
					orderSort = Boolean.parseBoolean(sc.nextLine());
					
					Page<FlightDetails> showFlightsByPageNoAsSorted = flightMnmtService.showFlightsByPageNoAsSorted(pageNo, pageSize, orderSort, prop);
					showFlightsByPageNoAsSorted.forEach(System.out::println);
					break;
					
				case 4:
					System.out.print("Enter page size: ");
					pageSize = Integer.parseInt(sc.nextLine());
					flightMnmtService.showFlightsByPagination(pageSize);
					break;
					
				case 5:
					System.exit(0);
				default:
					System.err.println("Invalid Choice....");
				}
			}
			
		}catch (Exception e) {

			e.printStackTrace();
		}
	}
}
