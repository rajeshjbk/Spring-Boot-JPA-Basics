package com.raj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.FlightDetails;

public interface IFlightDetailsRepository extends JpaRepository<FlightDetails, Integer> {

	List<FlightDetails> findByTypeIs(String type);
	Iterable<FlightDetails> getByTypeEquals(String type);
	Iterable<FlightDetails> readByType(String type);
	
	Iterable<FlightDetails> findByCapacityBetween(double start, double end);
	Iterable<FlightDetails> findByFNameStartingWith(String initChars);
	Iterable<FlightDetails> findByFNameEndingWith(String lastChars);
	Iterable<FlightDetails> findByFNameContaining(String chars);
	Iterable<FlightDetails> findByFNameEquals(String name);
//	List<FlightDetails> findByCompanyInOrderByFNameAsc(String com1, String com2);
	Iterable<FlightDetails> findByCompanyLike(String company);
	
	Iterable<FlightDetails> findByCapacityGreaterThanEqualAndCapacityLessThanEqual(double min, double max);
//	Iterable<FlightDetails> findByCapacityBetweenOrCompanyInOrderByCompanyAsc(double start, double end);
	
}