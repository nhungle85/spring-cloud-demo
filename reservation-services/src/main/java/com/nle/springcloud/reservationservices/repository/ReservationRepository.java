package com.nle.springcloud.reservationservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nle.springcloud.reservationservices.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
