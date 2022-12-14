package com.nle.springcloud.roomreservationservices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
	private long id;
	private String roomName;
	private String roomNumber;
	private String bedInfo;
}
