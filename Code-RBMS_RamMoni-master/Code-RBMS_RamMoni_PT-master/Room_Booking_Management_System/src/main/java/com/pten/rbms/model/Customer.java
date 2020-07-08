package com.pten.rbms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//mark class as an Entity   
@Entity
//defining class name as Table name  
@Table

public class Customer {

	public Customer(int customerId, String userName, String firstName, String lastName,
			@Past @NotNull(message = "Invalid dateOfBirth") Date dateOfBirth,
			@Email(message = "Email should be valid") String email,
			@Size(min = 8, max = 10, message = "The password must be between 8 and 10 characters") String password) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;
	}

	// Defining CustomerId as primary key
	@Id
	@Column
	@GeneratedValue
	private int customerId;
	@Column(unique = true)
	private String userName;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	@Past
	@NotNull(message = "Invalid dateOfBirth")
	private Date dateOfBirth;
	@Column(unique = true)
	@Email(message = "Email should be valid")
	private String email;
	@Column
	@Size(min = 8, max = 10, message 
    = "The password must be between 8 and 10 characters")
	private String password;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
