package com.tsc.hotel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

	private int id;

	private String street;
	private String city;

	public Address(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}

}
