package com.pten.rbms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pten.rbms.model.Booking;
import com.pten.rbms.repository.BookingRepository;

@Service
public class BookingService implements IBookingService{

	@Autowired
	BookingRepository bookingRepository;

	// getting all Customers record by using the method findaAll() of CrudRepository
	public List<Booking> getAllBooking() {
		List<Booking> bookings = new ArrayList<Booking>();
		bookingRepository.findAll().forEach(bookings1 -> bookings.add(bookings1));
		return bookings;
	}

	// getting a specific Customer by using the method findById() of CrudRepository
	public Booking getBookingById(int id) {
		return bookingRepository.findById(id).get();
	}

	// saving a specific customer by using the method save() of CrudRepository
	public void saveOrUpdate(Booking bookings) {
		bookingRepository.save(bookings);
	}

	// deleting a specific customer by using the method deleteById() of
	// CrudRepository
	public void delete(int id) {
		bookingRepository.deleteById(id);
	}

	// updating a customer
	public void update(Booking bookings, int bookingid) {
		bookingRepository.save(bookings);
	}
	
	@Override
	public List<Booking> findRoomsOpenForBooking(Date resrvStartDate, Date resrvEndDate, int roomId)
	{
		List<Booking> bookings = new ArrayList<Booking>();
		bookingRepository.findRoomsOpenForBooking(resrvStartDate, resrvEndDate,roomId).forEach(bookings1 -> bookings.add(bookings1));
		return bookings;
	}

}
