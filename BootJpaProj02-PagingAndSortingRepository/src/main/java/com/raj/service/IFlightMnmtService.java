package com.raj.service;

import org.springframework.data.domain.Page;

import com.raj.entity.FlightDetails;

public interface IFlightMnmtService {

	Iterable<FlightDetails> showFlightsAsSorted(boolean ascOrder, String ...props);
	Page<FlightDetails> showFlightsByPageNo(int pageno, int pageSize);
	Page<FlightDetails> showFlightsByPageNoAsSorted(int pageNo, int pageSize,boolean ascOrder, String ...props);
	void showFlightsByPagination(int pageSize);
}
