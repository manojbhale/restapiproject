package com.tsc.hotel.service;

import com.tsc.hotel.entities.DeliveryPartner;

public interface DeliveryService {
	public void addDeliveryPartner(DeliveryPartner delivery);

	public void updateDeliveryPartner(DeliveryPartner delivery);

	public DeliveryPartner getDeliveryPartnerById(Integer deliveryId);

	public void deleteDeliveryPartnerById(Integer deliveryId);

	public DeliveryPartner getDeliveryPartnerByPartnerName(String partnerName);

}
