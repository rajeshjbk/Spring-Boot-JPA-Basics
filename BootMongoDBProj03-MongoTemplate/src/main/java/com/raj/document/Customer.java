package com.raj.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "CUSTOMER_DOCUMENTS")
public class Customer {

	@Id
	private String id;
	
	@NonNull
	private String cname;
	@NonNull
	private String addrs;
	@NonNull
	private Double billAmt;
}
