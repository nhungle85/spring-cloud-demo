package com.nle.springcloud.roomreservationservices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Guest {
	private long id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String address;
	private String country;
	private String state;
	private String phoneNumber;
}
