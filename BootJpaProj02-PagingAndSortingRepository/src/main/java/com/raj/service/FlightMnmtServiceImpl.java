package com.raj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.raj.entity.FlightDetails;
import com.raj.repository.IFlightDetailsPagingAndSortRepo;

@Service
public class FlightMnmtServiceImpl implements IFlightMnmtService {

	@Autowired
	private IFlightDetailsPagingAndSortRepo flightRepo;

	@Override
	public Iterable<FlightDetails> showFlightsAsSorted(boolean ascOrder, String... props) {

		//create the Sort object
		Sort sort = Sort.by(ascOrder?Sort.Direction.ASC: Sort.Direction.DESC, props);

		//invoke the findAll(sort) method
		Iterable<FlightDetails> all = flightRepo.findAll(sort);

		return all;
	}

	@Override
	public Page<FlightDetails> showFlightsByPageNo(int pageNo, int pageSize) {

		//create Pageable object having inputs
		Pageable  pageable= PageRequest.of(pageNo, pageSize);

		//execute the code
		Page<FlightDetails> pages = flightRepo.findAll(pageable);
		return pages;
	}

	@Override
	public Page<FlightDetails> showFlightsByPageNoAsSorted(int pageNo, int pageSize, boolean ascOrder,
			String... props) {

		//create the Sort object
		Sort sort = Sort.by(ascOrder?Sort.Direction.ASC: Sort.Direction.DESC, props);

		//invoke the findAll(sort) method
		Iterable<FlightDetails> all = flightRepo.findAll(sort);

		//create Pageable object having inputs
		Pageable  pageable= PageRequest.of(pageNo, pageSize);

		//execute the code
		Page<FlightDetails> pages = flightRepo.findAll(pageable);
		return pages;
	
	}

	@Override
	public void showFlightsByPagination(int pageSize) {
		
		//get total records
		long count = flightRepo.count();
		
		//decide no.of pages
		long pagesCount = count/pageSize;
		if(count%pageSize!=0) {
			pagesCount++;
		}
		
		//display records through pagination
		for(int i=0; i<pagesCount; ++i) {
			
			//create Pageable object
			Pageable pageable = PageRequest.of(i, pageSize);
			//get each page
			Page<FlightDetails> page = flightRepo.findAll(pageable);
			System.out.println("Records of Page:: "+(page.getNumber()+1)+"/"+page.getTotalPages());
			page.forEach(System.out::println);
			System.out.println("------------------------------------------------");
		}
	}
}
