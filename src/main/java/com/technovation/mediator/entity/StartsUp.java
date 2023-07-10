package com.technovation.mediator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//CompanyName, FounderName,Location,Industry, CompanyEmail, Total Valuation, List of Services,Description

@Entity
@Data
public class StartsUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer startId;
	private String companyName;
	private String founderName;
	private String location;
	private String industryType;
	private String companyEmail;
	private Double totalValuation;
	private String services;
	private String description;
   
}
