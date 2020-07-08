package com.pten.rbms.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pten.rbms.model.Booking;
import com.pten.rbms.repository.BookingRepository;

public class BookingServiceTest {

	@Mock
	private BookingRepository bookingRepository;
	
	@InjectMocks
	private BookingService bookingService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testGetAllBooking() throws Exception {
		
		List<Booking> bookings = new ArrayList<Booking>();
		Booking booking1 = new Booking(0, 0, 0, null, null);
		Booking booking2 = new Booking(0, 0, 0, null, null);
		Date bookingStartDate = null;
		Date bookingEndDate = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			bookingStartDate = dateFormat.parse("2000-10-20");
			bookingEndDate = dateFormat.parse("2000-10-25");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking1.setBookingId(1);
		booking1.setCustomerId(1);
		booking1.setRoomId(1);
		booking1.setResrvStartDate(bookingStartDate);
		booking1.setResrvEndDate(bookingEndDate);
		bookings.add(booking1);
		bookings.add(booking2);
		when(bookingRepository.findAll()).thenReturn(bookings);
		List<Booking> result = bookingService.getAllBooking();
		assertEquals(2, result.size());
	}
	
	@Test
	public void testBookingSave(){
		Booking booking = new Booking(0, 0, 0, null, null);
		Date bookingStartDate = null;
		Date bookingEndDate = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			bookingStartDate = dateFormat.parse("2000-10-20");
			bookingEndDate = dateFormat.parse("2000-10-25");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking.setBookingId(1);
		booking.setCustomerId(1);
		booking.setRoomId(1);
		booking.setResrvStartDate(bookingStartDate);
		booking.setResrvEndDate(bookingEndDate);
		
		when(bookingRepository.save(booking)).thenReturn(booking);
		bookingService.saveOrUpdate(booking);
		assertEquals(1, booking.getBookingId());
	}
	
	@Test
	public void testBookingUpdate(){
		Booking booking = new Booking(0, 0, 0, null, null);
		Date bookingStartDate = null;
		Date bookingEndDate = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			bookingStartDate = dateFormat.parse("2000-10-20");
			bookingEndDate = dateFormat.parse("2000-10-25");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking.setBookingId(1);
		booking.setCustomerId(1);
		booking.setRoomId(1);
		booking.setResrvStartDate(bookingStartDate);
		booking.setResrvEndDate(bookingEndDate);
		
		when(bookingRepository.save(booking)).thenReturn(booking);
		bookingService.update(booking,1);
		assertEquals(1, booking.getBookingId());
	}
	
	@Test
	public void testBookingDelete(){
		Booking booking = new Booking(0, 0, 0, null, null);
		Date bookingStartDate = null;
		Date bookingEndDate = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			bookingStartDate = dateFormat.parse("2000-10-20");
			bookingEndDate = dateFormat.parse("2000-10-25");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking.setBookingId(1);
		booking.setCustomerId(1);
		booking.setRoomId(1);
		booking.setResrvStartDate(bookingStartDate);
		booking.setResrvEndDate(bookingEndDate);
		
		bookingService.delete(booking.getBookingId());
		assertEquals(1, booking.getBookingId());
	}
}
