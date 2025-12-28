package com.raj.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.FlightDetails;
import com.raj.repository.IFlightDetailsCrudRepo;

@Service
public class FlightMnmtServiceImpl implements IFlightMnmtService {

	@Autowired
	private IFlightDetailsCrudRepo crudRepo;

	@Override
	public String saveDetail(FlightDetails details) {
		
		FlightDetails flightDetails = crudRepo.save(details);
		
		return "Flight Details are saved with FNo: "+flightDetails.getFNo();
	}

	@Override
	public String registerFlights(List<FlightDetails> list) {
		
		Iterable<FlightDetails> savedList = crudRepo.saveAll(list);		
		//get id values
		List<Integer> ids = StreamSupport.stream(savedList.spliterator(), false)
				              .map(FlightDetails::getFNo).collect(Collectors.toList());
		
		/*List<Integer> ids = new ArrayList<>();
		savedList.forEach(flight -> ids.add(flight.getFNo()));
		*/
		
		return ids.size()+" no. of Flights are saved with id values:: "+ids;
	}

	@Override
	public boolean isFlightAvailable(Integer fNo) {
		
		boolean existsById = crudRepo.existsById(fNo);
		return existsById;
	}

	@Override
	public Iterable<FlightDetails> viewAllFights() {
		
		return crudRepo.findAll();
	}

}
