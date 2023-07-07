package com.technovation.mediator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//FirstName, LastName, Email, No. of StartUps Invested, Amount Invested, Industry

@Entity
@Data
public class Investors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invId;
	private String firstName;
	private String lastName;
	private String email;
	private Integer startUpsInvested;	//hide from ui page
	private Double amountInvested;
    
	//private Industry industry;
	
}
