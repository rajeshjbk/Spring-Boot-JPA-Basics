package com.raj.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class JobSeeker implements Serializable{

	@Id
	@SequenceGenerator(name = "seq1",sequenceName = "jsid_seq", initialValue = 101,allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer jsid;
	
	@Column(length = 30)
	@NonNull
	private String jsname;
	
	@Column(length = 30)
	@NonNull
	private String jsaddrs;
	
	@Lob
	@NonNull
	private byte[] photo;
	
	@Lob
	@NonNull
	private char[] resume;
}
