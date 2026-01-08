package com.raj.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AM_OTM_POLITICIAN")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Politician {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "PID_SEQ",initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer pid;
	
	@Column(length = 30)
	@NonNull
	private String pname;
	
	@Column(length = 30)
	@NonNull
	private String paddrs;
	
	@NonNull
	private Integer age;
	
	@ManyToOne(targetEntity = PoliticalParty.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "PP_ID", referencedColumnName = "PARTYID")
	private PoliticalParty party; //HAS-A property to build Many to One Association

	
	public Politician(){
		
		System.out.println("Politician:: 0-param constructor");
	}
	@Override
	public String toString() {
		return "Politician [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", age=" + age + "]";
	}
	
}
