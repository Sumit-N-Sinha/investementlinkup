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

//FirstName, LastName, Email,  StartUps Invested, Amount Invested, Industry

@Entity
@Data
public class Investor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invId;
	@NotNull
	private String firstName;
	@NotNull
	private String email;
	@NotNull
	private String industry;
	@NotNull
	private Integer startUpsInvested;	
	@NotNull
	private Double amountInvested;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="name")
	private User user;
	
}
