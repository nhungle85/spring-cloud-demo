package com.nle.springcloud.roomreservationservices;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
	private long id;
	private long roomId;
	private long guestId;
	private Date date;
}
