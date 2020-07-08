package com.pten.rbms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.pten.rbms.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
    @Query("select b from Booking b where b.resrvStartDate <: bookingStartDate and b.resrvEndDate >: bookingEndDate and b.roomId =':bookingRoomId'")
    List<Booking> findRoomsOpenForBooking(Date resrvStartDate, Date resrvEndDate, int roomId);

}