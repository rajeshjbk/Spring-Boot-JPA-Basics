package com.raj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.raj.entity.FlightDetails;
import com.raj.repository.IFlightDetailsJpaRepository;
@Service
public class FlightMgmtServiceImpl implements IFlightMgmtService {

	@Autowired
	private IFlightDetailsJpaRepository flightRepo;

	@Override
	public String removeFlighstDetailsByIdsInBatch(List<Integer> ids) {
		
		List<FlightDetails> allById = flightRepo.findAllById(ids);
		
		if(allById.size()!=0) {
			
			flightRepo.deleteAllByIdInBatch(ids);
			
			return allById.size()+" no. of Flights Details are Deleted.";
		}
		
		return "No Flights Details are deleted.";
	}

	@Override
	public List<FlightDetails> showFlightsDetailsData(FlightDetails data, boolean ascOrder, String... props) {
		
		//create Example object
		Example<FlightDetails> example = Example.of(data);
		
		//create Sort object
		Sort sort = Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, props);
		
		List<FlightDetails> all = flightRepo.findAll(example, sort);
		return all;
	}



	
}
