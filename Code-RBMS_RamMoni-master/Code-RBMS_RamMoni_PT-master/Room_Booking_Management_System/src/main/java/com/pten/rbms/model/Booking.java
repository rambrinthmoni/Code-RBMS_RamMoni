package com.pten.rbms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.pten.rbms.util.ValidBooking;

//mark class as an Entity   
@Entity
//defining class name as Table name  
@Table
public class Booking {

	@ValidBooking
	public Booking(int bookingId, int customerId, int roomId,
			@NotNull(message = "Invalid Booking Start Date") Date resrvStartDate,
			@NotNull(message = "Invalid Booking End Date") Date resrvEndDate) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.roomId = roomId;
		this.resrvStartDate = resrvStartDate;
		this.resrvEndDate = resrvEndDate;
	}

	// Defining CustomerId as primary key
	@Id
	@Column
	@GeneratedValue
	int bookingId;
	int customerId;
	@Column
	int roomId;
	@Column
	@NotNull(message = "Invalid Booking Start Date")
	@Future
	Date resrvStartDate;
	@Column
	@NotNull(message = "Invalid Booking End Date")
	@Future
	Date resrvEndDate;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Date getResrvStartDate() {
		return resrvStartDate;
	}

	public void setResrvStartDate(Date resrvStartDate) {
		this.resrvStartDate = resrvStartDate;
	}

	public Date getResrvEndDate() {
		return resrvEndDate;
	}

	public void setResrvEndDate(Date resrvEndDate) {
		this.resrvEndDate = resrvEndDate;
	}

}
