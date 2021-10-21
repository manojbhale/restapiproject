package com.tsc.hotel.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotelId;

	private String hotelName;

	// @JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JsonIgnore
	@JoinColumn(name = "hotelId")
	private Set<MenuItem> menuItem;

	// @JsonIgnore
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinTable(name = "hotel_delivery", joinColumns = @JoinColumn(name = "hotel_id", referencedColumnName = "hotelId"), inverseJoinColumns = @JoinColumn(name = "delivery_id", referencedColumnName = "deliveryId"))
	private Set<DeliveryPartner> delivery;

	public Hotel(String hotelName, Address address, Set<MenuItem> menuItem, Set<DeliveryPartner> delivery) {
		super();
		this.hotelName = hotelName;
		this.address = address;
		this.menuItem = menuItem;
		this.delivery = delivery;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", address=" + address + ", menuItem=" + menuItem + ", delivery="
				+ delivery + "]";
	}

	@Override
	public int hashCode() {
		return hotelName.hashCode() + address.getStreetName().hashCode() + hotelId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj instanceof Hotel) {
			Hotel hotel = (Hotel) obj;
			if (hotelName.equals(hotel.getHotelName())
					&& address.getStreetName().equals(hotel.getAddress().getStreetName())
					&& (hotelId != hotel.getHotelId())) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

}
