package com.amritha.ars.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Customer extends User {

	@Column(name = "passport_number")
	private String passportNumber;
	
	public Customer() {}
	
    public Customer(String name, String email) {
		super(name, email);
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

}


