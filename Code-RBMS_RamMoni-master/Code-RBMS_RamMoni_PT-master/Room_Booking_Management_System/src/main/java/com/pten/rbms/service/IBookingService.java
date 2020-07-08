package com.pten.rbms.service;

import java.util.Date;
import java.util.List;

import com.pten.rbms.model.Booking;

public interface IBookingService {
	List<Booking> findRoomsOpenForBooking(Date resrvStartDate, Date resrvEndDate, int roomId);
}
