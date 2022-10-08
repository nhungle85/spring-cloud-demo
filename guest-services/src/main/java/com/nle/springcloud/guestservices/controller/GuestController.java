package com.nle.springcloud.guestservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nle.springcloud.guestservices.model.Guest;
import com.nle.springcloud.guestservices.service.GuestServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/guests")
@AllArgsConstructor
public class GuestController {
	private GuestServices service;
	
	@GetMapping
	public Iterable<Guest> getAllGuest() {
		return service.getAllGuests();
	}
	
	@GetMapping("/{id}")
	public Guest getGuestById(@PathVariable("id") long id) {
		return service.getGuestById(id);
	}
	
}
