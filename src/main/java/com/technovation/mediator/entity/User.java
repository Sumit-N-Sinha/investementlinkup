package com.technovation.mediator.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;


@Entity
@Table(name="myData")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	@Email
	private String emailId;
	
	private long phone;
	
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
}
