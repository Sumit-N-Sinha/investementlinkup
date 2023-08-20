package com.technovation.mediator.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;


@Entity
@Table(name="myData")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String name;
	@NotNull
	@Email
	private String emailId;
	
	@NotNull
	private long phone;
	
	@NotNull
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
}
