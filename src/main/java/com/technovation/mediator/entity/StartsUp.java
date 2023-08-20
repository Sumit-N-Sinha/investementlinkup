package com.technovation.mediator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

//CompanyName, FounderName,Location,Industry, CompanyEmail, Total Valuation, List of Services,Description

@Entity
@Data
public class StartsUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer startId;
	
	@NotNull
	private String companyName;
	
	@NotNull
	private String founderName;
	@NotNull
	private String location;
	@NotNull
	private String industryType;
	@NotNull
	private String companyEmail;
	@NotNull
	private Double totalValuation;
	@NotNull
	private String services;
	@NotNull
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="name")
	private User user;
   
}
