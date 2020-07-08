package com.pten.rbms;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pten.rbms.controller.BookingController;

@SpringBootTest
class RoomBookingManagementSystemApplicationTests {

	@Autowired
	private BookingController controller;
	
	public void testContexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
