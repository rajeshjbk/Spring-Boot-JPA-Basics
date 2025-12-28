package com.raj.service;

import java.util.List;

import com.raj.entity.FlightDetails;

public interface IFlightMgmtService {

	String removeFlighstDetailsByIdsInBatch(List<Integer> ids);
	
	List<FlightDetails> showFlightsDetailsData(FlightDetails data, boolean ascOrder, String ...props);

	
}
