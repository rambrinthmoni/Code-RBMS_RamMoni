package com.pten.rbms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity   
@Entity
//defining class name as Table name  
@Table

public class Room {

	public Room(int roomId, String roomType, int rent) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.rent = rent;
	}

	// Defining CustomerId as primary key
	@Id
	@Column
	@GeneratedValue
	private int roomId;
	@Column
	private String roomType;
	@Column
	private int rent;
	/*
	 * @Column private String currentBookingStartdate;
	 * 
	 * @Column private String currentBookingEnddate;
	 */
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}
	
}
