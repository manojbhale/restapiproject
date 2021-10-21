package com.tsc.hotel.service;

import java.util.List;

import com.tsc.hotel.entities.Hotel;
import com.tsc.hotel.exception.HotelIdNotFoundException;
import com.tsc.hotel.exception.HotelNotFoundException;

public interface HotelService {

	public Hotel addHotel(Hotel hotel);

	public void updateHotel(Hotel hotel);

	public Hotel getHotelById(Integer hotelId) throws HotelIdNotFoundException;

	public void deleteHotelById(Integer hotelId) throws HotelIdNotFoundException;

	List<Hotel> getHotelByCityName(String cityName) throws HotelNotFoundException;

	List<Hotel> getHotelByMenuName(String menuName) throws HotelNotFoundException;

	List<Hotel> getHotelByDelivery(String partnerName) throws HotelNotFoundException;
	
	List<Hotel> getHotelByStreetName(String streetName) throws HotelNotFoundException;

	List<Hotel> getHotelByStreetAndMenu(String streetName, String menuName) throws HotelNotFoundException;

}
