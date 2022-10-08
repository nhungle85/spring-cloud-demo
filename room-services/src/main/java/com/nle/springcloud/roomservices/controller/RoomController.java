package com.nle.springcloud.roomservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nle.springcloud.roomservices.model.Room;
import com.nle.springcloud.roomservices.service.RoomService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomController {
	private RoomService service;
	
	@GetMapping
	public Iterable<Room> getAllRoom() {
		return service.getAllRoom();
	}
	
	@GetMapping("/{id}")
	public Room getRoomById(@PathVariable("id") long id) {
		return service.getRoomById(id);
	}
}
