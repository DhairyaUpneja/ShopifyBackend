package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.modal.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
