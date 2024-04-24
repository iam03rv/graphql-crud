package com.useraddress.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useraddress.operation.model.Addresses;

public interface AddressesRepository extends JpaRepository<Addresses, Long> {

}
