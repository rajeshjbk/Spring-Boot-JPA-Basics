package com.raj.entity;

import org.springframework.stereotype.Component;

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

@Component
@Data
@Table(name = "Flight_Details")
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class FlightDetails {

	@Column(name = "FNO")
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
	/*   @SequenceGenerator(name = "Seq1",sequenceName = "FNO_Seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator ="Seq1",strategy = GenerationType.SEQUENCE)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fNo;
	
	@Column(name = "FNAME",length = 30)
//	@NonNull
	private String fName;
	
	@Column(name = "COMPANY",length = 30)
//	@NonNull
	private String company;
	
	@Column(name = "TYPE",length = 30)
//	@NonNull
	private String type;
	
	@Column(name = "CAPACITY")
//	@NonNull
	private Integer capacity;
	
}
