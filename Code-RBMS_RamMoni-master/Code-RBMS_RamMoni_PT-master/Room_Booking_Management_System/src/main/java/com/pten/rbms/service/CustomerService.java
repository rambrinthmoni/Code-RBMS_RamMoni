package com.pten.rbms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pten.rbms.model.Customer;
import com.pten.rbms.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	// getting all Customers record by using the method findaAll() of CrudRepository
	public List<Customer> getAllCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customers1 -> customers.add(customers1));
		return customers;
	}

	// getting a specific Customer by using the method findById() of CrudRepository
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).get();
	}

	// saving a specific customer by using the method save() of CrudRepository
	public void saveOrUpdate(Customer customers) {
		customerRepository.save(customers);
	}

	// deleting a specific customer by using the method deleteById() of
	// CrudRepository
	public void delete(int id) {
		customerRepository.deleteById(id);
	}

	// updating a customer
	public void update(Customer customers, int roomid) {
		customerRepository.save(customers);
	}

}
