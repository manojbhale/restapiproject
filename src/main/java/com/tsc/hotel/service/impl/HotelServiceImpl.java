package com.tsc.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tsc.hotel.entities.Hotel;
import com.tsc.hotel.exception.HotelIdNotFoundException;
import com.tsc.hotel.exception.HotelNotFoundException;
import com.tsc.hotel.repository.HotelRepository;
import com.tsc.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	private final HotelRepository hotelRepositiory;

	@Autowired
	public HotelServiceImpl(HotelRepository hotelRepositiory) {
		this.hotelRepositiory = hotelRepositiory;
	}

	@Override
	public Hotel addHotel(Hotel hotel) {

		return hotelRepositiory.save(hotel);
	}

	@Override
	public void updateHotel(@RequestBody Hotel hotel) {
		hotelRepositiory.save(hotel);

	}

	@Override
	public Hotel getHotelById(Integer hotelId) {
		return hotelRepositiory.findById(hotelId).orElseThrow(
				() -> new HotelIdNotFoundException("Hotel id not Found Exception Please Enter Valid Hotel Id"));
	}

	@Override
	public void deleteHotelById(Integer hotelId) {
		if (hotelId <= 0) {
			throw new RuntimeException("Hotel id Should be gratter than zero..");
		}
		hotelRepositiory.deleteById(hotelId);
	}

	@Override
	public List<Hotel> getHotelByCityName(String cityName) {
		List<Hotel> hotelList = hotelRepositiory.findByAddressCityName(cityName);
		if (hotelList.isEmpty()) {
			throw new HotelNotFoundException("Hotel Not Found for this city : " + cityName);
		}

		return hotelList;
	}

	@Override
	public List<Hotel> getHotelByMenuName(String menuName) {
		List<Hotel> hotelList = hotelRepositiory.findByMenuItemMenuItemName(menuName);
		if (hotelList.isEmpty()) {
			throw new HotelNotFoundException("Hotel Not Found for this menu : " + menuName);
		}
		return hotelList;
	}

	@Override
	public List<Hotel> getHotelByDelivery(String partnerName) {

		List<Hotel> hotelList = hotelRepositiory.findByMenuItemMenuItemName(partnerName);
		if (hotelList.isEmpty()) {
			throw new HotelNotFoundException("Hotel Not Found for this partner : " + partnerName);
		}
		return hotelList;
	}

	@Override
	public List<Hotel> getHotelByStreetAndMenu(String streetName, String menuItemName) {

		// return
		// hotelRepositiory.findByAddressStreetNameAndMenuItemMenuItemName(streetName,
		// menuItemName);

		List<Hotel> hotelList = hotelRepositiory.getHotelByStreetAndMenu(streetName, menuItemName);
		if (hotelList.isEmpty()) {
			throw new HotelNotFoundException(
					"Hotel Not Found for this street : " + streetName + " and this for menu" + menuItemName);

		}
		return hotelList;
	}

	@Override
	public List<Hotel> getHotelByStreetName(String streetName) throws HotelNotFoundException {

		List<Hotel> hotelList = hotelRepositiory.findByAddressStreetName(streetName);
		if (hotelList.isEmpty()) {
			throw new HotelNotFoundException("Hotel Not Found for this street : " + streetName);

		}
		return hotelList;
	}

}
