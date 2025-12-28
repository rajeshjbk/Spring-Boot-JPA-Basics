package com.raj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.raj.entity.FlightDetails;

public interface IFlightDetailsPagingAndSortRepo extends CrudRepository<FlightDetails, Integer> ,PagingAndSortingRepository<FlightDetails, Integer> {

}
