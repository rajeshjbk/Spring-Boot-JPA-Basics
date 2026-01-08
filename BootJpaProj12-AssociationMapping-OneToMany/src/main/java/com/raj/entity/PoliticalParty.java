package com.raj.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "AM_OTM_PARTY")
public class PoliticalParty {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "ID_SEQ",initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer partyId;
	
	@Column(length = 30)
	@NonNull
	private String partyName;
	
	@Column(length = 30)
	@NonNull
	private String symbol;
	
	@OneToMany(targetEntity = Politician.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "PP_ID", referencedColumnName = "PARTYID")
	private Set<Politician> politicians; //Collection of HAS-A property to build many to one association

	public PoliticalParty() {
		
		System.out.println("PoliticalParty:: 0-param constructor");
	}
	
	@Override
	public String toString() {
		return "PoliticalParty [partyId=" + partyId + ", partyName=" + partyName + ", symbol=" + symbol + "]";
	}	
}
