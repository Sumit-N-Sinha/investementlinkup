package com.technovation.mediator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Industry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer indId;
	
	private String indName;
	private Double valuation;
	
	
}
