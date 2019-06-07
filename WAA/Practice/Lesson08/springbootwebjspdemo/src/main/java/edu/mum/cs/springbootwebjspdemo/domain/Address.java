package edu.mum.cs.springbootwebjspdemo.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class Address {

	@NotEmpty(message = "String.empty")
	private String street;
	private String city;

	@Size(min = 2, max = 2, message = "Size.state")
	private String state;

	private String zipCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
