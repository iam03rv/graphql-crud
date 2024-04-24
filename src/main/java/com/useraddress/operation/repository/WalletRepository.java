package com.useraddress.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useraddress.operation.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

}
