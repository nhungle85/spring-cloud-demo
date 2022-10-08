package com.nle.springcloud.guestservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="GUEST")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Guest {
	@Id
	@Column(name = "GUEST_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
}
