package com.tsc.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsc.hotel.entities.Hotel;
import com.tsc.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels-restapi")
public class HotelController {

	private final HotelService hotelService;

	@Autowired
	public HotelController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}

	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
		Hotel addHotel = hotelService.addHotel(hotel);
		// custom header
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Your Hotel Added Successfully...");
		return ResponseEntity.ok().headers(headers).body(addHotel);
	}

	@PutMapping("/hotels")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel) {
		hotelService.updateHotel(hotel);
		return ResponseEntity.ok("updated Hotel successfully...");
	}

	@GetMapping("/hotels/hotel-by-id/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Integer hotelId) {
		Hotel hotelById = hotelService.getHotelById(hotelId);
		System.out.println(hotelById);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get your Hotel Successfully...");
		return ResponseEntity.ok().headers(headers).body(hotelById);
	}

	@DeleteMapping("/hotels/hotel-by-id/{hotelId}")
	public ResponseEntity<Void> deleteHotelById(@PathVariable Integer hotelId) {
		hotelService.deleteHotelById(hotelId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "deleted your Hotel Successfully...");
		return ResponseEntity.ok().headers(headers).build();
	}

	@GetMapping("/hotels/hotel-by-city/{cityName}")
	public ResponseEntity<List<Hotel>> getHotelByCityName(@PathVariable String cityName) {

		List<Hotel> hotelByCityName = hotelService.getHotelByCityName(cityName);

		return ResponseEntity.ok().body(hotelByCityName);
	}

	@GetMapping("/hotels/hotel-by-menuName/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelByMenuName(@PathVariable String menuName) {
		List<Hotel> hotelByMenuName = hotelService.getHotelByMenuName(menuName);
		return ResponseEntity.ok().body(hotelByMenuName);
	}

	@GetMapping("/hotels/hotel-by-partnerName/{partnerName}")
	public ResponseEntity<List<Hotel>> getHotelByDelivery(@PathVariable String partnerName) {
		List<Hotel> hotelByDelivery = hotelService.getHotelByDelivery(partnerName);

		return ResponseEntity.ok().body(hotelByDelivery);
	}

	@GetMapping("/hotels/hotel-by-streetName/{streetName}/menuName/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelByStreetAndMenu(@PathVariable String streetName,
			@PathVariable String menuName) {
		List<Hotel> hotelByStreetAndMenu = hotelService.getHotelByStreetAndMenu(streetName, menuName);
		return ResponseEntity.ok().body(hotelByStreetAndMenu);
	}

	@GetMapping("/hotels/hotel-by-streetName/{streetName}")
	public ResponseEntity<List<Hotel>> getHotelByStreetName(@PathVariable String streetName) {
		List<Hotel> hotelByStreetName = hotelService.getHotelByStreetName(streetName);
		return ResponseEntity.ok().body(hotelByStreetName);
	}
}
