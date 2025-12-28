package com.raj.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection  = "EMPLOYEE_DOC")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	private String id;
	
	@NonNull
	private String eName;
	
	@NonNull
	private String eAdd;
	
	@NonNull
	private Double salary;
	
}
