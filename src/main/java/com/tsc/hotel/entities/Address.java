package com.tsc.hotel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	private String streetName;

	private String cityName;

	private Integer zipcode;

	private String stateName;

	public Address(String streetName, String cityName, Integer zipcode, String stateName) {
		super();
		this.streetName = streetName;
		this.cityName = cityName;
		this.zipcode = zipcode;
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", cityName=" + cityName + ", zipcode=" + zipcode + ", stateName="
				+ stateName + "]";
	}

	@Override
	public int hashCode() {
		return streetName.hashCode() + addressId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj instanceof Address) {
			Address address = (Address) obj;
			if (streetName.equals(address.getStreetName()) && (addressId != address.getAddressId())) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}
}
