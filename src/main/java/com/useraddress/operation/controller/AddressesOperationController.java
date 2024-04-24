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

import com.useraddress.operation.model.Addresses;
import com.useraddress.operation.repository.AddressesRepository;

@RestController
@RequestMapping("/api")
public class AddressesOperationController {

	@Autowired
	private AddressesRepository addressesRepository;

	@PostMapping("/addresses")
	public Addresses createCustomer(@RequestBody Addresses address) {
		return addressesRepository.save(address);
	}

	@GetMapping("/addresses")
	public List<Addresses> getCustomers() {
		return addressesRepository.findAll();
	}

	@GetMapping("addresses/{ADDRESS_ID}")
	public Addresses getCustomer(@PathVariable(value = "ADDRESS_ID") long id) {
		return addressesRepository.findById(id).get();
	}

	@PutMapping("/addresses/{ADDRESS_ID}")
	public Addresses Address(@PathVariable(value = "ADDRESS_ID") Long addressId, @RequestBody Addresses address) {
		Addresses a = addressesRepository.findById(addressId).get();

		a.setApartmentNo(address.getApartmentNo());
		a.setCity(address.getCity());
		a.setCountry(address.getCountry());
		a.setPincode(address.getPincode());
		a.setCustomer(address.getCustomer());

		return addressesRepository.save(a);
	}

	@DeleteMapping("/addresses")
	public String deleteAllAddresses() {
		addressesRepository.deleteAll();
		return "All addresses have been deleted successfully.";
	}

	@DeleteMapping("/addresses/{ADDRESS_ID}")
	public String deleteAddress(@PathVariable (value = "ADDRESS_ID")Long addressId) {
		addressesRepository.deleteById(addressId);
		return "the address" + "(" + addressId + ") data" + " have been deleted successfully.";
	}
}