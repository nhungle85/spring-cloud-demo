package com.nle.springcloud.roomreservationservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("room-reservations")
public class RoomReservationServiceController {
	private final RestTemplate restTemplate;

	public RoomReservationServiceController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@GetMapping
	public List<RoomReservation> getRoomReservations() {
		List<Room> rooms = getAllRooms();
		List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();
		rooms.forEach(room -> {
			RoomReservation reservation = new RoomReservation();
			
			reservation.setRoomName(room.getName());
			reservation.setRoomNumber(room.getRoomNumber());
			reservation.setRoomId(room.getId());
			
			roomReservations.add(reservation);
		});
		
		return roomReservations;
	}

	private List<Room> getAllRooms() {
		ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange("http://ROOMSERVICES/rooms", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Room>>() {
				});

		return roomResponse.getBody();
	}
}
