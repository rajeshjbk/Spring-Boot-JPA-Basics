package com.raj.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.raj.entity.FlightDetails;
import com.raj.service.IFlightMgmtService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IFlightMgmtService flightMgmtService;

	@Override
	public void run(String... args) throws Exception {

		/*try {
		
		     String removeFlighstDetailsByIdsInBatch = flightMgmtService.removeFlighstDetailsByIdsInBatch(List.of(5,7,9,6,8));
		     System.out.println(removeFlighstDetailsByIdsInBatch);
		     
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		*/
		try {

          FlightDetails details = new FlightDetails();
          details.setType("AirBus");
//          details.setCompany("AirIndia");
          details.setCompany("Indigo");
                    
          List<FlightDetails> showFlightsDetailsData = flightMgmtService.showFlightsDetailsData(details, false, "capacity");
          showFlightsDetailsData.forEach(System.out::println);
          
		}catch (Exception e) {

			e.printStackTrace();
		}
	}
}
