package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.raj.entity.FlightDetails;

public interface IFlightDetailsJpaRepository extends JpaRepository<FlightDetails, Integer> {

}
