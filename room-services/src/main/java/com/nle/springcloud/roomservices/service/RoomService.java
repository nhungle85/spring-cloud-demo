package com.nle.springcloud.roomservices.service;

import org.springframework.stereotype.Service;

import com.nle.springcloud.roomservices.model.Room;
import com.nle.springcloud.roomservices.repository.RoomRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomService {
	private RoomRepository repository;
	
	public Iterable<Room> getAllRoom() {
		return repository.findAll();
	}
	
	public Room getRoomById(long id) {
		//handling exception later
		return repository.findById(id).get();
	}
}
