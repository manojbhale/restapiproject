package com.tsc.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsc.hotel.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
