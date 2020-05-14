package com.manish.RemedyManagement.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Details {


	@NotEmpty(message="firstName is required")
	private String firstName;
	@NotEmpty(message="lastName is required")
	private String lastName;
	@NotEmpty
	@Size(min=10,message="Contact should be of 10 digits")
	private String contact;
	
	private int id;
	
	@NotEmpty
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}", message = "Password should contain of a min of 6 characters and an uppercase and lowercase letter")
	private String password;
	
	private Date dob;
	
	private String gender;
	
	private String level;
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Details(String firstName, String lastName, String contact, int id, String password, Date dob, String gender,
			String level) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.id = id;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.level = level;
		
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date date) {
		this.dob = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Details [ firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ ", id=" + id + ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", level=" + level
				+ "]";
	}
	
	
	
	
}
