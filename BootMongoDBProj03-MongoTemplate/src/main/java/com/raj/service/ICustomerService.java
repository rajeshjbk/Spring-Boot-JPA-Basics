package com.raj.service;

import java.util.List;

import com.raj.document.Customer;

public interface ICustomerService {

	String saveCustomer(Customer cust);
	String saveCustomersBatch(List<Customer> list);
	List<Customer> showCustomersByBillAmts(Double start, Double end);
	String discountBillAmount(String addrs, Double discountPercent);
	String removeCustomersByBillAmounts(Double start, Double end);
	long showCustomersCount(String addrs);
}
