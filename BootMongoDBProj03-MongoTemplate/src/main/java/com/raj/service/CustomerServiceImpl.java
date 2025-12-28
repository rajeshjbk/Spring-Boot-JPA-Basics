package com.raj.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.raj.document.Customer;
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String saveCustomer(Customer cust) {
		
		Customer save = mongoTemplate.save(cust);
		return "New Customer is saved with ID: "+save.getId();
	}

	@Override
	public String saveCustomersBatch(List<Customer> list) {

        //save the document
		Collection<Customer> insertAll = mongoTemplate.insertAll(list);
		
		//get id values
		List<String> ids = StreamSupport.stream(insertAll.spliterator(), false).map(Customer::getId).collect(Collectors.toList());
		
		return ids.size()+" no.of Customers are saved,";
	}

	@Override
	public List<Customer> showCustomersByBillAmts(Double start, Double end) {
		
		//prepare Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("billAmt").gte(start).lte(end));
		List<Customer> list = mongoTemplate.find(query, Customer.class);
		return list;
	}

	@Override
	public String discountBillAmount(String addrs, Double discountPercent) {
		//prepare Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("addrs").is(addrs));
		
		//prepare Update object
		Update update = new Update();
		update.multiply("billAmt", (100-discountPercent)/100.0);
		
		//execute the logic
		UpdateResult result = mongoTemplate.updateMulti(query, update, Customer.class);
		
		return result.getModifiedCount()+" no.of docs are updated.";
	}

	@Override
	public String removeCustomersByBillAmounts(Double start, Double end) {
		
		//prepare Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("billAmt").gte(start).lte(end));
		
		//execute the logic
		int size = mongoTemplate.findAllAndRemove(query, Customer.class).size();
		return size+" no.of docs are removed";
	}

	@Override
	public long showCustomersCount(String addrs) {
		//prepare Query object
		Query query = new Query();
		query.addCriteria(Criteria.where("addrs").is(addrs));
		
		//get count of records
		long count = mongoTemplate.count(query, Customer.class);
		
		return count;
	}
}
