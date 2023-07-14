package com.technovation.mediator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

//FirstName, LastName, Email,  StartUps Invested, Amount Invested, Industry

@Entity
@Data
public class Investor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invId;
	private String firstName;
	private String lastName;
	private String email;
	private String industry;
	private Integer startUpsInvested;	
	private Double amountInvested;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private User user;
	
}
