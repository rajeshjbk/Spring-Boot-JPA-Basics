package com.raj.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.raj.entity.FlightDetails;

import jakarta.transaction.Transactional;

public interface IFlightDetailsRepository extends JpaRepository<FlightDetails, Integer> {

	//=================== Query methods for select operations ====================
	@Query("from FlightDetails where capacity>=?1 and capacity<=?2")
	List<FlightDetails> showFlightByCapacity(double start,double end);
	/*@Query("from FlightDetails where capacity>=:min and capacity<=:max")
	List<FlightDetails> showFlightByCapacity(@Param("min") double start,@Param("max") double end);*/


	//=================== Bulk Entity Query ======================================
	@Query("from FlightDetails where company in (:comp1,:comp2,:comp3)")
	List<FlightDetails> showFlightsByCompany(String  comp1, String  comp2, String  comp3);

	//=================== Bulk Scalar Query(selecting specific multiple col/prop values) ==================
	@Query("select fNo,fName,company from FlightDetails where company in (:comp1,:comp2,:comp3)")
	List<Object[]> showFlightsDataByCompany(String  comp1, String  comp2, String  comp3);

	//=================== Bulk Scalar Query(selecting specific single col/prop values) ==================
	@Query("select fName from FlightDetails where company in (:comp1,:comp2,:comp3)")
	List<String> showFlightNamesByCompany(String  comp1, String  comp2, String  comp3);

	//================== Single Row Entity Query ================================
	@Query("from FlightDetails where fName=:name")
	Optional<FlightDetails> showFlightByName(String name);

	//================== Single Row Scalar Query(multiple col values)================================
	@Query("select fNo, fName,capacity from FlightDetails where fName=:name")
	Optional<Object> showFlightDataByName(String name);

	//================== Single Row Scalar Query(single col values)================================
	@Query("select capacity from FlightDetails where fName=:name")
	Optional<Integer> showFlightCapacityByName(String name);

	//===================== For Aggregate operations =======================================
	@Query("select distinct count(company) from FlightDetails")
	long showUniqueCompaniesCount();
	
	@Query("select count(*),min(capacity),max(capacity),avg(capacity),sum(capacity) from FlightDetails")
	Object showAggregateData();
	
	//=================================== Update Query ==================================
	@Query("update FlightDetails set capacity=round(capacity+capacity* :hikePercent/100) where company in (:comp1,:comp2)")
	@Modifying
	@Transactional
	long updateFlightsByCapacityByCompanies(String comp1, String comp2, double hikePercent);
	
	//=================================== Delete Query ==================================
	@Query("delete from FlightDetails where capacity>=:start and capacity<=:end")
	@Modifying
	@Transactional
	int deleteFlightsByCapacityRange(double start, double end);
	
	//=================================== Native SQL Query ==================================
	@Query(value="select now() from dual", nativeQuery = true)
	LocalDateTime showSystemDateTime();
	
}
