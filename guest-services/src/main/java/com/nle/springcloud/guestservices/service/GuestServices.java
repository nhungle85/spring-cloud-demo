package com.nle.springcloud.guestservices.service;

import org.springframework.stereotype.Service;

import com.nle.springcloud.guestservices.model.Guest;
import com.nle.springcloud.guestservices.repository.GuestRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GuestServices {
	private GuestRepository repository;
	
	public Iterable<Guest> getAllGuests() {
		return repository.findAll();
	}
	
	public Guest getGuestById(long id) {
		//handling exception later..
		return repository.findById(id).get();
	}

}
