package edu.mum.cs.springbootwebjspdemo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee implements Serializable {
	private static final long serialVersionUID = -908L;

	private Long id;
	
	@NotEmpty // any characters including "space"
//	 @NotNull
//	 @NotBlank // must have characters BESIDES "space"
	@Size(min = 4, max = 50, message = "Size.firstName")
	private String firstName;
	
	@NotEmpty(message = "aaa")
	private String lastName;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	// @DateTimeFormat(iso = ISO.DATE) // yyyy-MM-dd
	// @DateTimeFormat(style = "L-") // July 12, 2001
	// @DateTimeFormat(pattern="hh:mm:ss")
	private Date birthDate;

	// @NotEmpty //Gives NO Integer validation exception
	@NotNull
	private Integer salaryLevel;

	@Valid
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getSalaryLevel() {
		return salaryLevel;
	}

	public void setSalaryLevel(Integer salaryLevel) {
		this.salaryLevel = salaryLevel;
	}

}
