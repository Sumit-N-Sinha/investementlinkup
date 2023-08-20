package com.technovation.mediator.dto;

import lombok.Data;

@Data
public class InvestorDTO {

	private String firstName;
	private String email;
	private String industry;
	private Integer startUpsInvested;	
	private Double amountInvested;
}
