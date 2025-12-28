package com.raj.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
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
public class BankAccount {

	//Data properties
	@Id
	@SequenceGenerator(name = "seq1",sequenceName = "acno_seq", initialValue = 100000,allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Long acno;
	
	@Column(length = 30)
	@NonNull
	private String holderName;
	
	@Column(length = 30)
	@NonNull
	private String addrs;
	@NonNull
	private Double amount;
	
	//MetaData properties
	@Version
	private Integer updateCount;
	
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime openedOn;
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime lastOperatedOn;
	
	@Column(length = 30)
	private String openedBy;
	
	@Column(length = 30)
	private String updatedBy;
	
	@Column(length = 20)
	private String active_SW="active";
	
}
