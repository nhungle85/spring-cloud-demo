package com.nle.springcloud.guestservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nle.springcloud.guestservices.model.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

}
