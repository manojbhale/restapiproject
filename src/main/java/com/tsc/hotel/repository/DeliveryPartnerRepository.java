package com.tsc.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsc.hotel.entities.DeliveryPartner;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Integer> {
	//Derived query
	//findByPropertyName,getByPropertyName,readByPropertyName
	
	DeliveryPartner findByPartnerName(String partnerName);
	

}
