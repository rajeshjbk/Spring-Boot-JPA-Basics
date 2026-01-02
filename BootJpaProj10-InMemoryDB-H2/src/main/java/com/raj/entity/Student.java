package com.raj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
public class Student {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "sid_seq", initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer sid;
	
	@Column(length = 30)
	@NonNull
	private String sname;
	
	@Column(length = 30)
	@NonNull
	private String saddrs;
	
	@NonNull
	private Float avg;
}
