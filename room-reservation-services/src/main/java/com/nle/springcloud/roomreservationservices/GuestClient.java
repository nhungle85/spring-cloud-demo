package com.nle.springcloud.roomreservationservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("guestservices")
public interface GuestClient {
	@GetMapping("/guests")
	List<Guest> getAllGuest();
	
	@GetMapping("/guests/{id}")
	public Guest getGuestById(@PathVariable("id") long id);
}
