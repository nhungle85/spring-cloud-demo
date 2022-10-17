package com.nle.springcloud.roomreservationservices;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomReservation {
	private long roomId;
	private long guestId;
	private String roomName;
	private String roomNumber;
	private String firstName;
	private String lastName;
	private Date date;
}
