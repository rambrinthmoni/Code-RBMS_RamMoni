package com.pten.rbms.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pten.rbms.RoomBookingManagementSystemApplication;
import com.pten.rbms.model.Booking;
import com.pten.rbms.model.Customer;
import com.pten.rbms.model.Room;
import com.pten.rbms.service.BookingService;
import com.pten.rbms.service.CustomerService;
import com.pten.rbms.service.RoomService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RoomBookingManagementSystemApplication.class)
@WebMvcTest(value = BookingController.class)
public class BookingControllerTest {

	@MockBean
	private CustomerService customerService;
	@MockBean
	private BookingService bookingService;
	@MockBean
	private RoomService roomService;

	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/*
	 * Testing Room CURD Operations Testing post() creating a Customer
	 */
	@Test
	public void testCreateCustomer() throws Exception {
		String uri = "/addcustomers";

		Customer customer = new Customer(1, "", "", "", null, "", "");
		Date dateOfBirth = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateOfBirth = dateFormat.parse("2000-10-07");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customer.setUserName("TestUser001");
		customer.setDateOfBirth(dateOfBirth);
		customer.setEmail("test@gmail.com");
		customer.setFirstName("TestFirstName");
		customer.setLastName("TestLastName");
		customer.setPassword("123456788");

		String inputJson = this.mapToJson(customer);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/*
	 * Testing get() for a specific room
	 */
	@Test
	public void testGetCustomerById() throws Exception {
		String uri = "/customer/1";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/*
	 * Testing get() all Customers
	 */
	@Test
	public void testGetAllCustomers() throws Exception {
		String uri = "/customer";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	
	/*
	 * Testing update() for a specific room
	 */
	@Test
	public void testUpdateCustomer() throws Exception {
		String uri = "/customers";
		Customer customer = new Customer(1, "", "", "", null, "", "");
		Date dateOfBirth = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateOfBirth = dateFormat.parse("2000-10-07");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customer.setUserName("TestUser001");
		customer.setDateOfBirth(dateOfBirth);
		customer.setEmail("test@gmail.com");
		customer.setFirstName("TestFirstName");
		customer.setLastName("TestLastName");
		customer.setPassword("123456788");
		String inputJson = this.mapToJson(customer);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	/*
	 * Testing delete() for a specific Customer
	 */
	@Test
	public void testDeleteCustomer() throws Exception {
		String uri = "/customer/1";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	/*
	 * Testing Room CURD Operations Testing post() creating a room
	 */
	@Test
	public void testCreateRoom() throws Exception {
		String uri = "/addrooms";
		Room room = new Room(1, "K", 5000);

		String inputJson = this.mapToJson(room);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/*
	 * Testing get() for a specific room
	 */
	@Test
	public void testGetRoomById() throws Exception {
		String uri = "/room/1";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/*
	 * Testing get() all rooms
	 */
	@Test
	public void testGetAllRooms() throws Exception {
		String uri = "/room";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/*
	 * Testing update() for a specific room
	 */
	@Test
	public void testUpdateRoom() throws Exception {
		String uri = "/rooms";
		Room room = new Room(1, "Q", 4000);
		String inputJson = this.mapToJson(room);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/*
	 * Testing delete() for a specific room
	 */
	@Test
	public void testDeleteRoom() throws Exception {
		String uri = "/room/1";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/*
	 * Testing Room CURD Operations Testing post() creating a Booking
	 */
	
	@Test
	public void testCreateBooking() throws Exception {
		String uri = "/bookRoom";

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

		String inputJson = this.mapToJson(booking);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status); // Since customer wont be available
	}

	/*
	 * Testing get() for a specific room
	 */
	@Test
	public void testGetBookingById() throws Exception {
		String uri = "/booking/1";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/*
	 * Testing get() all Customers
	 */
	@Test
	public void testGetAllBookings() throws Exception {
		String uri = "/booking";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	
	/*
	 * Testing update() for a specific room
	 */
	@Test
	public void testUpdateBooking() throws Exception {
		String uri = "/bookings";
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
		String inputJson = this.mapToJson(booking);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	/*
	 * Testing delete() for a specific Customer
	 */
	@Test
	public void testDeleteBooking() throws Exception {
		String uri = "/booking/1";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(""))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	
	public String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	public <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
}
