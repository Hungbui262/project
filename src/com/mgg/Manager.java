package com.mgg;

import java.util.List;

public class Manager {
	private String managerCode;
	private String firstName;
	private String lastName;
	private Address address;
	List<String> emailAddress;

	public Manager(String code,  String firstName, String lastName, Address address, List<String> emailAddress) {
		this.managerCode = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
	}
	public String getCode() {
		return managerCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}

	public List<String> getEmailAddress() {
		return emailAddress;
	}
}

