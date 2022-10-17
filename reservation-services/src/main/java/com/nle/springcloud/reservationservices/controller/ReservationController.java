package com.nle.springcloud.reservationservices.controller;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nle.springcloud.reservationservices.model.Reservation;
import com.nle.springcloud.reservationservices.service.ReservationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {
	private ReservationService service;
	
	@GetMapping
	public Iterable<Reservation> getAllReservation(@RequestParam(name="date", required = false) Date date) {
		if (date != null) {
			return service.getReservationByDate(date);
		}
		return service.getAllReservation();
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable("id") long id) {
		return service.getReservationById(id);
	}
}
