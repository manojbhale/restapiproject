package com.tsc.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsc.hotel.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	// derived query
	List<Hotel> findByAddressCityName(String cityName);

	List<Hotel> findByMenuItemMenuItemName(String menuName);

	List<Hotel> findByDeliveryPartnerName(String partnerName);

	// List<Hotel> findByAddressStreetNameAndMenuItemMenuItemName(String streetName,
	// String menuItemName);

	// jpql using @query annoation

	@Query("From Hotel h inner join h.address a inner join h.menuItem mi where a.streetName=?1 AND mi.menuItemName=?2")
	List<Hotel> getHotelByStreetAndMenu(String streetName, String menuItemName);

	List<Hotel> findByAddressStreetName(String streetName);

}
