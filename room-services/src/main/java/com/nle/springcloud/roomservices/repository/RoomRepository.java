package com.nle.springcloud.roomservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nle.springcloud.roomservices.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
