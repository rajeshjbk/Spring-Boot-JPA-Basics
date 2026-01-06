package com.raj.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable {

	private Integer eno;
	private String ename;
	private String eaddres;
	private Double salary;
	
}
