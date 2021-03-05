package com.mgg;
import java.util.List;
/**
 * This class models individual person 
 */
public class Person {
	private String code;
	private String type;
	private String firstName;
	private String lastName;
	private Address address;
	List<String> emailAddress;

	public Person(String code, String type, String firstName, String lastName, Address address,
		List<String> emailAddress) {
		this.code = code;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
	}
	public Person(String code, String firstName, String lastName, Address address,
			List<String> emailAddress) {
			this.code = code;
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.emailAddress = emailAddress;
		}

	public String getCode() {
		return code;
	}

	public String getType() {
		return type;
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
