package com.raj.runners;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.FlightDetails;
import com.raj.repository.IFlightDetailsRepository;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IFlightDetailsRepository flightDetailsRepo;

	@Override
	public void run(String... args) throws Exception {
		try(Scanner sc = new Scanner(System.in)){

			flightDetailsRepo.showFlightByCapacity(100.0, 300.0).forEach(System.out::println);

			System.out.println("------------------------------------------------------------------");
			
			flightDetailsRepo.showFlightsByCompany("Indigo", "AirIndia", "AirIndia+").forEach(System.out::println);
			
			System.out.println("------------------------------------------------------------------");
			
			flightDetailsRepo.showFlightsDataByCompany("Indigo", "AirIndia", "AirIndia+").forEach(row->{
				System.out.println(Arrays.toString(row));
			});
			
			System.out.println("------------------------------------------------------------------");
			flightDetailsRepo.showFlightNamesByCompany("Indigo", "AirIndia", "AirIndia+").forEach(System.out::println);
		
			System.out.println("------------------------------------------------------------------");
			
			Optional<FlightDetails> opt = flightDetailsRepo.showFlightByName("45588HED");
			if(opt.isPresent())
				System.out.println("Flight Details are:: "+opt.get());
			else
				System.out.println("Flight not found.");
			
			System.out.println("------------------------------------------------------------------");
			
			Optional<Object> opt1 = flightDetailsRepo.showFlightDataByName("45588HED");
			if(opt1.isPresent())
				System.out.println("Flight Details are:: "+Arrays.toString((Object[])opt1.get()));
			else
				System.out.println("Flight not found.");
			
			System.out.println("------------------------------------------------------------------");
			
			Optional<Integer> opt2 = flightDetailsRepo.showFlightCapacityByName("45588HED");
			if(opt2.isPresent())
				System.out.println("Flight Capacity:: "+opt2.get());
			else
				System.out.println("Flight not found.");
			
			System.out.println("------------------------------------------------------------------");
			
			long showUniqueCompaniesCount = flightDetailsRepo.showUniqueCompaniesCount();
			System.out.println("Companies count:: "+showUniqueCompaniesCount);
			
			System.out.println("------------------------------------------------------------------");
			
			System.out.println("Multiple aggregate results are:: "+Arrays.toString((Object[])flightDetailsRepo.showAggregateData()));
			
			System.out.println("------------------------------------------------------------------");
			
			System.out.println("No.of Flight that are updated:: "+flightDetailsRepo.updateFlightsByCapacityByCompanies("Indigo", "h", 10.0));
			System.out.println("------------------------------------------------------------------");
		   
			System.out.println("No.of Flights that are deleted:: "+flightDetailsRepo.deleteFlightsByCapacityRange(200.0, 300.0));
			System.out.println("------------------------------------------------------------------");
			
			System.out.println("System Date and Time:: "+flightDetailsRepo.showSystemDateTime());
			System.out.println("------------------------------------------------------------------");
	
		}catch (Exception e) {

			e.printStackTrace();
		}
	}
}
