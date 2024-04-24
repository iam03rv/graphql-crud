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

import com.useraddress.operation.model.Customer;
import com.useraddress.operation.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class OperationController {

//	@GetMapping("/check")
//	public String check() {
//		return "working!!!";	
//	}
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@GetMapping("/customer")
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("customer/{CUSTOMER_ID}")
	public Customer getCustomer(@PathVariable(value = "CUSTOMER_ID") long id) {
		return customerRepository.findById(id).get();
	}

	@PutMapping("/customer/{CUSTOMR_ID}")
	public Customer updateCustomer(@PathVariable(value = "CUSTOMER_ID") Long customerId,
			@RequestBody Customer customer) {
		Customer c = customerRepository.findById(customerId).get();
		c.setName(customer.getName());
		c.setMobileNo(customer.getMobileNo());
		c.setAddresses(customer.getAddresses());
//		c.setProduct(customer.getProduct());
		c.setWallet(customer.getWallet());
		return customerRepository.save(c);
	}

	@DeleteMapping("/customer")
	public String deleteAllCustomers() {
		customerRepository.deleteAll();
		return "All customers have been deleted successfully.";
	}

	@DeleteMapping("/customer/{CUSTOMER_ID}")
	public String deleteCustomer(@PathVariable(value = "CUSTOMER_ID") Long customerId) {
		customerRepository.deleteById(customerId);
		return "the customer" + "(" + customerId + ") data" + " have been deleted successfully.";
	}

}
