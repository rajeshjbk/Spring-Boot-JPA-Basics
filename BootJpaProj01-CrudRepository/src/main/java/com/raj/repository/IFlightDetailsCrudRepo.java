package com.raj.repository;

import org.springframework.data.repository.CrudRepository;

import com.raj.entity.FlightDetails;

public interface IFlightDetailsCrudRepo extends CrudRepository<FlightDetails, Integer> {

}
