package com.useraddress.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useraddress.operation.model.CardNo;

public interface CardNoRepo extends JpaRepository<CardNo,Long> {
	
}
