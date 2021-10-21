package com.tsc.hotel.service;

import java.util.List;

import com.tsc.hotel.entities.MenuItem;

public interface MenuItemService {

	List<MenuItem> getMenusByHotel(String hotelName);
	
}
