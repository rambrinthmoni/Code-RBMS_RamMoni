package com.pten.rbms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pten.rbms.model.Booking;
import com.pten.rbms.model.Customer;
import com.pten.rbms.model.Room;
import com.pten.rbms.service.BookingService;
import com.pten.rbms.service.CustomerService;
import com.pten.rbms.service.RoomService;

//mark class as Controller  
@RestController
public class BookingController {

	// autowire the BooksService class
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private BookingService bookingService;

	// CURD operation for Customer
	// creating a get mapping that retrieves all the customer details from the
	// database
	@GetMapping("/customer")
	private List<Customer> getAllCustomers() {
		return customerService.getAllCustomer();
	}

	// creating a get mapping that retrieves the detail of a specific Customer
	@GetMapping("/customer/{customerid}")
	private Customer getCustomers(@PathVariable("customerid") int customerid) {
		return customerService.getCustomerById(customerid);
	}

	// creating a delete mapping that deletes a specified Customer
	@DeleteMapping("/customer/{customerid}")
	private void deleteCustomer(@PathVariable("customerid") int customerid) {
		customerService.delete(customerid);
	}

	// creating post mapping that post the Customer detail in the database
	@PostMapping("/addcustomers")
	private ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customers) {
		customerService.saveOrUpdate(customers);
		return ResponseEntity.ok(customers); // return 200, with json body
	}

	// creating put mapping that updates the book detail
	@PutMapping("/customers")
	private Customer update(@RequestBody Customer customers) {
		customerService.saveOrUpdate(customers);
		return customers;
	}

	// CURD operation for Room
	// creating a get mapping that retrieves all the Room details from the database
	@GetMapping("/room")
	private List<Room> getAllrooms() {
		return roomService.getAllRooms();
	}

	// creating a get mapping that retrieves the detail of a specific Room
	@GetMapping("/room/{roomid}")
	private Room getRooms(@PathVariable("roomid") int roomid) {
		return roomService.getRoomsById(roomid);
	}

	// creating a delete mapping that deletes a specified Room
	@DeleteMapping("/room/{roomid}")
	private void deleteRoom(@PathVariable("roomid") int roomid) {
		roomService.delete(roomid);
	}

	// creating post mapping that post the Room detail in the database
	@PostMapping("/addrooms")
	private int saveRoom(@RequestBody Room rooms) {
		roomService.saveOrUpdate(rooms);
		return rooms.getRoomId();
	}

	// creating put mapping that updates the book detail
	@PutMapping("/rooms")
	private Room update(@RequestBody Room rooms) {
		roomService.saveOrUpdate(rooms);
		return rooms;
	}

	// CURD operation for Booking
	// creating a get mapping that retrieves all the Booking details from the
	// database
	@GetMapping("/booking")
	private List<Booking> getAllBooking() {
		return bookingService.getAllBooking();
	}

	// creating a get mapping that retrieves the detail of a specific Booking
	@GetMapping("/booking/{bookingid}")
	private Booking getBooking(@PathVariable("bookingid") int bookingid) {
		return bookingService.getBookingById(bookingid);
	}

	// creating a delete mapping that deletes a specified Booking
	@DeleteMapping("/booking/{bookingid}")
	private void deleteBooking(@PathVariable("bookingid") int bookingid) {
		bookingService.delete(bookingid);
	}

	// creating put mapping that deletes the Booking details
	@PutMapping("/bookings")
	private Booking update(@RequestBody Booking booking) {
		bookingService.saveOrUpdate(booking);
		return booking;
	}

	// creates a new booking for a valid request.
	@PostMapping("/bookRoom")
	private ResponseEntity<Booking> roomBooking(@RequestBody Booking booking) {
		List<Booking> bookings = new ArrayList<Booking>();
		int customerID = booking.getCustomerId();
		int roomId = booking.getRoomId();

		Date bookingStartDate = booking.getResrvStartDate();
		Date bookingEndDate = booking.getResrvEndDate();

		Customer customer;
		Room room;
		// Validate the customerID
		customer = customerService.getCustomerById(customerID);
		if (null == customer) {
			// This is not a valid customer ...
			//throw new InvalidCustomerException("Not a Valid Customer ....");
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // NOT_FOUND(404, "Not Found")
		}
		// Validate if the roomId is valid
		room = roomService.getRoomsById(roomId);
		if (null == room) {
			// This is not a valid Room ...
			//throw new InvalidRoomException("Not a Valid Room ....");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // NOT_FOUND(404, "Not Found")
		}
		// Check if the room are available in the period requested
		bookings = bookingService.findRoomsOpenForBooking(bookingStartDate, bookingEndDate, roomId);
		if (bookings.size() > 0) {
			// This room is not available for booking ...
			//throw new NoBookingAvailableException("No Rooms availbale in this period  ....");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // BAD_REQUEST(400, "Bad Request")
		}
		bookingService.saveOrUpdate(booking);
		// Room Booked successfully....
		return ResponseEntity.status(HttpStatus.CREATED).body(null); // CREATED(201, "Created")
	}
}
