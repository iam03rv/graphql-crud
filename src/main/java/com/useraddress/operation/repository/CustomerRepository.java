package com.useraddress.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useraddress.operation.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
