package com.tsc.hotel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;

import com.tsc.hotel.entities.Address;
import com.tsc.hotel.entities.DeliveryPartner;
import com.tsc.hotel.entities.Hotel;
import com.tsc.hotel.entities.MenuItem;
import com.tsc.hotel.service.DeliveryService;
import com.tsc.hotel.service.HotelService;
import com.tsc.hotel.service.MenuItemService;

@SpringBootApplication
public class TscHotelappRestapiApplication implements CommandLineRunner {

	private final HotelService hotelService;
	private final DeliveryService deliveryService;
	private final MenuItemService menuItemService;

	@Autowired
	public TscHotelappRestapiApplication(HotelService hotelService, DeliveryService deliveryService,
			MenuItemService menuItemService) {
		super();
		this.hotelService = hotelService;
		this.deliveryService = deliveryService;
		this.menuItemService = menuItemService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TscHotelappRestapiApplication.class, args);
		System.out.println("*****************************************************************");
		System.out.println("Jai Shree Ram...");
		System.out.println("*****************************************************************");
	}

	@Override
	public void run(String... args) throws Exception {

		// addHotel();
		// updateHotel();
		// deleteHotel();
		// getHotelByCityName();
		// getHotelByMenuName();
		// getHotelByDelivery();
		// getHotelByStreetNameAndMenuName();
		// getMenusByHotel();

	}

	private void getHotelByDelivery() {
		List<Hotel> delivery = hotelService.getHotelByDelivery("zomato");
		System.out.println(delivery);
		delivery.stream().forEach(System.out::println);
	}

	private void getHotelByMenuName() {
		List<Hotel> menuName = hotelService.getHotelByMenuName("paneer paratha");
		System.out.println(menuName);
		menuName.stream().forEach(System.out::println);
	}

	private void getHotelByCityName() {
		List<Hotel> hotelByCityName = hotelService.getHotelByCityName("Dewas");
		System.out.println(hotelByCityName);
		hotelByCityName.stream().forEach(System.out::println);
	}

	private void getHotelByStreetNameAndMenuName() {
		System.out.println("******************************************");
		List<Hotel> streetAndMenuName = hotelService.getHotelByStreetAndMenu("A.B road", "gobhi paratha");
		System.out.println(streetAndMenuName);
		streetAndMenuName.stream().forEach(System.out::println);

		System.out.println("**************************************************");

		streetAndMenuName.stream().forEach((hotel) -> System.out
				.println(hotel.getHotelName() + "   " + hotel.getAddress().getCityName() + " " + hotel.getMenuItem()));
	}

	private void getMenusByHotel() {
		List<MenuItem> menusByHotel = menuItemService.getMenusByHotel("santusti");

		System.out.println(menusByHotel);

		menusByHotel.stream().forEach((menus) -> System.out.println(menus.getMenuItemName() + "  " + menus.getPrice()));
	}

	private void deleteHotel() {
		try {
			hotelService.deleteHotelById(6);
			System.out.println("Hotel Deleted Succesfully....");
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Hotel is not avaialble in the Record...");
			// throw new RecordNotFoundException("Hotel is not availble in the Record...");

		}
	}

	private void updateHotel() {
		Hotel dbHotel = hotelService.getHotelById(5);
		System.out.println(dbHotel);
		dbHotel.setHotelName("Agrawal");
		dbHotel.getAddress().setStreetName("Bus stand Road");

		hotelService.updateHotel(dbHotel);
	}

	private void addHotel() {
		// Address swagatAddress = new Address("A.B road","Dewas", 455001, "madhya //
		// pradesh");
		Address mukeshAddress = new Address("maxi road", "Dewas", 455001, "madhya pradesh");

		// MenuItem menu1 = new MenuItem("Aalu paratha", 30.00);
		MenuItem menu2 = new MenuItem("gobhi paratha", 50.00);
		// MenuItem menu3 = new MenuItem("paneer paratha", 90.00);
		MenuItem menu4 = new MenuItem("paneer paratha", 150.00);
		MenuItem menu5 = new MenuItem("Aalu paratha", 50.00);

		Set<MenuItem> mukeshMenu = new HashSet<>(Arrays.asList(menu2, menu4, menu5));

		// Set<MenuItem> mukeshMenu = new HashSet<>(Arrays.asList(menu1, menu2,
		// menu4,menu5));

		// DeliveryPartner delivery1 = new DeliveryPartner("swiggey", 20.50); //
		DeliveryPartner delivery2 = new DeliveryPartner("zomato", 30.50); //
		DeliveryPartner delivery3 = new DeliveryPartner("uberEats", 50.00);

		DeliveryPartner deliveryPartnerByPartnerName = deliveryService.getDeliveryPartnerByPartnerName("swiggey");
		System.out.println(deliveryPartnerByPartnerName.toString());

		// Set<DeliveryPartner> swagatDelivery = new HashSet<>(Arrays.asList(delivery1,
		// // delivery2));
		Set<DeliveryPartner> mukeshDelivery = new HashSet<>(Arrays.asList(deliveryPartnerByPartnerName));
		System.out.println("************************************************");
		System.out.println(mukeshDelivery.toString());

		System.out.println("************************************************"); //
		// Hotel swagatHotel = new Hotel("shiba resturant", swagatAddress,
		// swagatMenu,swagatDelivery);

		Hotel mukeshHotel = new Hotel("mukesh", mukeshAddress, mukeshMenu, mukeshDelivery);
		System.out.println("********************************************************************");
		System.out.println(mukeshHotel.toString());
		System.out.println("*********************************************************************");

		// hotelService.addHotel(swagatHotel); hotelService.addHotel(mukeshHotel);
	}

}
