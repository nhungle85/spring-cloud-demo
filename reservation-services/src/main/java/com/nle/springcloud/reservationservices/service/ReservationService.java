package com.nle.springcloud.reservationservices.service;

import org.springframework.stereotype.Service;

import com.nle.springcloud.reservationservices.model.Reservation;
import com.nle.springcloud.reservationservices.repository.ReservationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationService {
	private ReservationRepository repository;
	
	public Iterable<Reservation> getAllReservation() {
		return repository.findAll();
	}
	
	public Reservation getReservationById(long id) {
		//will handle exception later
		return repository.findById(id).get();
	}
}
