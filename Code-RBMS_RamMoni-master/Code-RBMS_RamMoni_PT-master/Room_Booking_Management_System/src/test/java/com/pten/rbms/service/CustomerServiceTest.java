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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pten.rbms.model.Customer;
import com.pten.rbms.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerService customerService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	// getAllCustomers
	@Test
	public void testGetAllCustomers() throws Exception {
		
		List<Customer> customers = new ArrayList<Customer>();
		Customer mockcustomerOne = new Customer(0, "", "", "", null, "", "");
		Customer mockcustomerTwo = new Customer(0, "", "", "", null, "", "");
		Date dateOfBirthOne = null;
		Date dateOfBirthTwo = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateOfBirthOne = dateFormat.parse("10-07-2000");
			dateOfBirthTwo = dateFormat.parse("10-07-1983");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mockcustomerOne.setUserName("TestUser001");
		mockcustomerOne.setDateOfBirth(dateOfBirthOne);
		mockcustomerOne.setEmail("test@gmail.com");
		mockcustomerOne.setFirstName("TestFirstName");
		mockcustomerOne.setLastName("TestLastName");
		mockcustomerOne.setPassword("123456788");
		customers.add(mockcustomerOne);

		mockcustomerTwo.setUserName("TestUser001");
		mockcustomerTwo.setDateOfBirth(dateOfBirthTwo);
		mockcustomerTwo.setEmail("test@gmail.com");
		mockcustomerTwo.setFirstName("TestFirstName");
		mockcustomerTwo.setLastName("TestLastName");
		mockcustomerTwo.setPassword("123456788");
		customers.add(mockcustomerTwo);
		
		when(customerRepository.findAll()).thenReturn(customers);
		List<Customer> result = customerService.getAllCustomer();
		assertEquals(2, result.size());
	
	}
	
	
	@Test
	public void testCustomerSave(){
		Customer mockcustomer = new Customer(1, "", "", "", null, "", "");
		Date dateOfBirthOne = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateOfBirthOne = dateFormat.parse("10-07-2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mockcustomer.setUserName("TestUser001");
		mockcustomer.setDateOfBirth(dateOfBirthOne);
		mockcustomer.setEmail("test@gmail.com");
		mockcustomer.setFirstName("TestFirstName");
		mockcustomer.setLastName("TestLastName");
		mockcustomer.setPassword("123456788");
		
		when(customerRepository.save(mockcustomer)).thenReturn(mockcustomer);
		customerService.saveOrUpdate(mockcustomer);
		assertEquals(1, mockcustomer.getCustomerId());
		
	}
	
	@Test
	public void testCustomerUpdate(){
		Customer mockcustomer = new Customer(1, "", "", "", null, "", "");
		Date dateOfBirthOne = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateOfBirthOne = dateFormat.parse("10-07-2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mockcustomer.setUserName("TestUser001");
		mockcustomer.setDateOfBirth(dateOfBirthOne);
		mockcustomer.setEmail("test@gmail.com");
		mockcustomer.setFirstName("TestFirstName");
		mockcustomer.setLastName("TestLastName");
		mockcustomer.setPassword("123456788");
		
		when(customerRepository.save(mockcustomer)).thenReturn(mockcustomer);
		customerService.update(mockcustomer, 1);
		assertEquals(1, mockcustomer.getCustomerId());

	}
	
	@Test
	public void testCustomerDelete(){
		Customer mockcustomer = new Customer(1, "", "", "", null, "", "");
		Date dateOfBirthOne = null;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dateOfBirthOne = dateFormat.parse("10-07-2000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mockcustomer.setUserName("TestUser001");
		mockcustomer.setDateOfBirth(dateOfBirthOne);
		mockcustomer.setEmail("test@gmail.com");
		mockcustomer.setFirstName("TestFirstName");
		mockcustomer.setLastName("TestLastName");
		mockcustomer.setPassword("123456788");
		
		customerService.delete(mockcustomer.getCustomerId());
		assertEquals(1, mockcustomer.getCustomerId());
        
	}
	
}

