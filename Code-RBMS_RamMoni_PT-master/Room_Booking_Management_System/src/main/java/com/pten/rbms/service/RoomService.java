package com.pten.rbms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pten.rbms.model.Room;
import com.pten.rbms.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;

	// getting all rooms record by using the method findaAll() of CrudRepository
	public List<Room> getAllRooms() {
		List<Room> rooms = new ArrayList<Room>();
		roomRepository.findAll().forEach(rooms1 -> rooms.add(rooms1));
		return rooms;
	}

	// getting a specific room by using the method findById() of CrudRepository
	public Room getRoomsById(int id) {
		return roomRepository.findById(id).get();
	}

	// saving a specific room by using the method save() of CrudRepository
	public void saveOrUpdate(Room rooms) {
		roomRepository.save(rooms);
	}

	// deleting a specific room by using the method deleteById() of CrudRepository
	public void delete(int id) {
		roomRepository.deleteById(id);
	}

	// updating a room
	public void update(Room rooms, int roomid) {
		roomRepository.save(rooms);
	}

}
