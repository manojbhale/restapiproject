package com.tsc.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsc.hotel.entities.DeliveryPartner;
import com.tsc.hotel.repository.DeliveryPartnerRepository;
import com.tsc.hotel.service.DeliveryService;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

	private final DeliveryPartnerRepository deliveryPartnerRepository;

	@Autowired
	public DeliveryServiceImpl(DeliveryPartnerRepository deliveryPartnerRepository) {
		super();
		this.deliveryPartnerRepository = deliveryPartnerRepository;
	}

	@Override
	public void addDeliveryPartner(DeliveryPartner delivery) {
		deliveryPartnerRepository.save(delivery);
	}

	@Override
	public void updateDeliveryPartner(DeliveryPartner delivery) {
		deliveryPartnerRepository.save(delivery);
	}

	@Override
	@Transactional
	public DeliveryPartner getDeliveryPartnerById(Integer deliveryId) {

		return deliveryPartnerRepository.findById(deliveryId).get();
	}

	@Override
	public void deleteDeliveryPartnerById(Integer deliveryId) {
		deliveryPartnerRepository.deleteById(deliveryId);
	}

	@Override
	@Transactional
	public DeliveryPartner getDeliveryPartnerByPartnerName(String partnerName) {

		return deliveryPartnerRepository.findByPartnerName(partnerName);
	}

}
