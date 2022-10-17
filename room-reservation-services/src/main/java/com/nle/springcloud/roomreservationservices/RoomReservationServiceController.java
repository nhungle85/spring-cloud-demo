package com.nle.springcloud.roomreservationservices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room-reservations")
public class RoomReservationServiceController {
	//private final RestTemplate restTemplate;
	private final RoomClient roomClient;
	private final ReservationClient reservationClient;
	private final GuestClient guestClient;

	public RoomReservationServiceController(RoomClient roomClient, ReservationClient reservationClient, GuestClient guestClient){
		super();
		this.roomClient = roomClient;
		this.reservationClient = reservationClient;
		this.guestClient = guestClient;
	}

	//http://localhost:8080/room-reservations?date=2020-01-01
	@GetMapping
	public List<RoomReservation> getRoomReservations(@RequestParam(name="date", required = false) String dateAsString) {
		List<Room> rooms = roomClient.getAllRooms();
		Map<Long, RoomReservation> roomReservations = new HashMap<Long, RoomReservation>();
		rooms.forEach(room -> {
			RoomReservation reservation = new RoomReservation();
			
			reservation.setRoomName(room.getRoomName());
			reservation.setRoomNumber(room.getRoomNumber());
			reservation.setRoomId(room.getId());
			
			roomReservations.put(room.getId(), reservation);
		});
		
		Date date = convertStringToDate(dateAsString);
		List<Reservation> reservations = reservationClient.getAllReservation(new java.sql.Date(date.getTime()));
		reservations.forEach(reservation -> {
			Guest guest = guestClient.getGuestById(reservation.getGuestId());
			RoomReservation roomReservation = roomReservations.get(reservation.getRoomId());
			roomReservation.setGuestId(guest.getId());
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());
			roomReservation.setDate(date);
		});
		
		return new ArrayList<RoomReservation> (roomReservations.values());
	}
	
	private Date convertStringToDate(String dateAsString) {
		
		//TODO: use java.time.Instant instead of java.util.Date
		// use java.time.LocalDate instead of java.sql.Date
		Date date = null;
		if (StringUtils.isNotBlank(dateAsString)) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyy-M-dd", Locale.ENGLISH);
			try {
				date = formatter.parse(dateAsString);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}	
		}
		return date;
	}

//	private List<Room> getAllRooms() {
//		ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange("http://ROOMSERVICES/rooms", HttpMethod.GET,
//				null, new ParameterizedTypeReference<List<Room>>() {
//				});
//
//		return roomResponse.getBody();
//	}
}
