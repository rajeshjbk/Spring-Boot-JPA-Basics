package com.raj.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "CLM_CRICKER_INFO")
public class CricketerInfo {
 
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "CID_SEQ", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer cid;
	
	@Column(length = 30)
	@NonNull
	private String cname;
	
	@Column(length = 30)
	@NonNull
	private String caddrs;
	
	@ElementCollection
	@CollectionTable(name = "CRICKER_FRIENDS", joinColumns = @JoinColumn(name="CKTR_ID",referencedColumnName = "CID"))
	@Column(name = "FRIENDS")
	@NonNull
	private List<String> friends;
	
	
	@ElementCollection
	@CollectionTable(name = "CRICKER_PHONES", joinColumns = @JoinColumn(name="CKTR_ID",referencedColumnName = "CID"))
	@Column(name = "PHONE_NUMBERS")
	@NonNull
	private Set<Long> phones;
	
	@ElementCollection
	@CollectionTable(name = "CRICKER_ID_DETAILS", joinColumns = @JoinColumn(name="CKTR_ID",referencedColumnName = "CID"))
	@MapKeyColumn(name = "ID_TYPE")
	@Column(name = "ID_NUMBER")
	@NonNull
	private Map<String, String> idDetails;
		
}
