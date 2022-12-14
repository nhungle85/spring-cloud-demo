package com.nle.springcloud.reservationservices.model;

import java.sql.Date;

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
@Table(name = "RESERVATION")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
	@Id
	@Column(name = "RESERVATION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "ROOM_ID")
	private long roomId;
	
	@Column(name = "GUEST_ID")
	private long guestId;

	@Column(name = "RES_DATE")
	private Date date;
}
