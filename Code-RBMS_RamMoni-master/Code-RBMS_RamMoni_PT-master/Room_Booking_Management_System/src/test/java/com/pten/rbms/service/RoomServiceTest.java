package com.pten.rbms.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pten.rbms.model.Room;
import com.pten.rbms.repository.RoomRepository;

public class RoomServiceTest {
	
	@Mock
	private RoomRepository roomRepository;
	
	@InjectMocks
	private RoomService roomService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void testGetAllRooms() throws Exception {
		
		List<Room> rooms = new ArrayList<Room>();
		Room room1 = new Room(1, "K", 5000);
		Room room2 = new Room(1, "Q", 4000);
		rooms.add(room1);
		rooms.add(room2);
		when(roomRepository.findAll()).thenReturn(rooms);
		List<Room> result = roomService.getAllRooms();
		assertEquals(2, result.size());
	
	}
	
	@Test
	public void testRoomSave(){
		Room room = new Room(1, "K", 5000);
		when(roomRepository.save(room)).thenReturn(room);
		roomService.saveOrUpdate(room);
		assertEquals(1, room.getRoomId());
	}
	
	@Test
	public void testRoomUpdate(){
		Room room = new Room(1, "K", 5000);
		when(roomRepository.save(room)).thenReturn(room);
		roomService.update(room, 1);
		assertEquals(1, room.getRoomId());
	}
	
	@Test
	public void testCustomerDelete(){
		Room room = new Room(1, "K", 5000);
		roomService.delete(room.getRoomId());
		assertEquals(1, room.getRoomId());
        
	}
}
