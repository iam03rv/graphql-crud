package com.useraddress.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useraddress.operation.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
