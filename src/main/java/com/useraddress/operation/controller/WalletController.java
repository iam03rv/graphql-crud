package com.useraddress.operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.useraddress.operation.model.Wallet;
import com.useraddress.operation.repository.WalletRepository;

@RestController
@RequestMapping("/api")

public class WalletController {
	@Autowired
	private WalletRepository walletRepository;

	@PostMapping("/wallet")
	public Wallet createWallet(@RequestBody Wallet wallet) {
		return walletRepository.save(wallet);
	}

	@GetMapping("/wallet")
	public List<Wallet> getWallets() {
		return walletRepository.findAll();
	}

	@GetMapping("wallet/{WALLET_ID}")
	public Wallet getWallet(@PathVariable(value = "WALLET_ID") Long id) {
		return walletRepository.findById(id).get();
	}

	@PutMapping("wallet/{WALLET_ID}")
	public Wallet updateWallet(@PathVariable(value = "WALLET_ID") Long walletId, @RequestBody Wallet wallet) {
		Wallet w = walletRepository.findById(walletId).get();
		w.setRupees(wallet.getRupees());
		w.setCustomer(wallet.getCustomer());
		return walletRepository.save(w);
	}

	@DeleteMapping("/wallet")
	public String deleteAllWallets() {
		walletRepository.deleteAll();
		return "All wallets have been deleted successfully.";
	}

	@DeleteMapping("/wallet/{WALLET_ID}")
	public String deleteWallet(@PathVariable(value = "WALLET_ID") Long walletId) {
		walletRepository.deleteById(walletId);
		return "the Wallet" + "(" + walletId + ") data" + " have been deleted successfully.";

	}
}
