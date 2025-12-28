package com.raj.service;

import java.util.List;

import com.raj.entity.FlightDetails;

public interface IFlightMnmtService {

	String saveDetail(FlightDetails details);
	
	String registerFlights(List<FlightDetails> list);
	
	boolean isFlightAvailable(Integer fNo);
	
	Iterable<FlightDetails> viewAllFights();
}
