package com.useraddress.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useraddress.operation.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
