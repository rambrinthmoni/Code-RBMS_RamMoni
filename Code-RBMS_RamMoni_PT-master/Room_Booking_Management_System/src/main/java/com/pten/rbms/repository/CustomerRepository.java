package com.pten.rbms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.pten.rbms.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	public List<Customer> findByUserName(String userName);
}
