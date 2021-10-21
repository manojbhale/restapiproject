package com.tsc.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsc.hotel.entities.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

	// Derived Queries

	List<MenuItem> findByHotelHotelName(String hotelName);

	// @query Annotaion

	@Query("From MenuItem mi INNER JOIN mi.hotel h on h.hotelName=?1")
	List<MenuItem> getMenusByHotel(String hotelName);

	// sql Query
	@Query(value = "select * from menu_item mi INNER JOIN hotel h  on mi.hotel_id=h.hotel_id where h.hotel_name=?1", nativeQuery = true)
	List<MenuItem> getMenusByHotelSQL(String hotelName);

}
