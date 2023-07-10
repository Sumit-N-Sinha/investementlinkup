package com.technovation.mediator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	public Investor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Investor(Integer invId, String firstName, String lastName, String email, String industry,
			Integer startUpsInvested, Double amountInvested) {
		super();
		this.invId = invId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.industry = industry;
		this.startUpsInvested = startUpsInvested;
		this.amountInvested = amountInvested;
	}

	@Override
	public String toString() {
		return "Investor [invId=" + invId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", industry=" + industry + ", startUpsInvested=" + startUpsInvested + ", amountInvested="
				+ amountInvested + "]";
	}

	public Integer getInvId() {
		return invId;
	}

	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getStartUpsInvested() {
		return startUpsInvested;
	}

	public void setStartUpsInvested(Integer startUpsInvested) {
		this.startUpsInvested = startUpsInvested;
	}

	public Double getAmountInvested() {
		return amountInvested;
	}

	public void setAmountInvested(Double amountInvested) {
		this.amountInvested = amountInvested;
	}
	
	
	
}
