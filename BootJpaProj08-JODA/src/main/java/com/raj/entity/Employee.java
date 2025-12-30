package com.raj.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "EMPLOYEE_RECORDS")
public class Employee {

	@Id
	@SequenceGenerator(name = "seq1",sequenceName = "eno_seq", initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer eno;
	
	@Column(length = 40)
	@NonNull
	private String ename;
	
	@NonNull
	private String eaddrs;
	
	@NonNull
	private LocalDate dob;
	
	@NonNull
	private LocalTime tob;
	
	@NonNull
	private LocalDateTime doj;
	
}