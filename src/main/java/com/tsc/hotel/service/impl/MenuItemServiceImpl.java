package com.tsc.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsc.hotel.entities.MenuItem;
import com.tsc.hotel.repository.MenuItemRepository;
import com.tsc.hotel.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	private final MenuItemRepository menuItemRepository;

	@Autowired
	public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
		super();
		this.menuItemRepository = menuItemRepository;
	}

	@Override
	public List<MenuItem> getMenusByHotel(String hotelName) {

		// return menuItemRepository.findByHotelHotelName(hotelName);  //derived query
		//return menuItemRepository.getMenusByHotel(hotelName); // @quer annotation jpql
		return menuItemRepository.getMenusByHotelSQL(hotelName); // @query withsql query 
	}

}
