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

import com.useraddress.operation.model.Product;
import com.useraddress.operation.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@GetMapping("/product")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@GetMapping("product/{PRODUCT_ID}")
	public Product getProduct(@PathVariable(value = "PRODUCT_ID") long id) {
		return productRepository.findById(id).get();
	}

	@PutMapping("/product/{PRODUCT_ID}")
	public Product updateProduct(@PathVariable(value = "PRODUCT_ID") Long productId, @RequestBody Product product) {
		Product p = productRepository.findById(productId).get();
		p.setName(product.getName());
		p.setCategories(product.getCategories());
		return productRepository.save(p);
	}

	@DeleteMapping("/product")
	public String deleteAllProducts() {
		productRepository.deleteAll();
		return "All products have been deleted successfully.";
	}

	@DeleteMapping("/product/{PRODUCT_ID}")
	public String deleteProduct(@PathVariable (value = "PRODUCT_ID") Long productId) {
		productRepository.deleteById(productId);
		return "the product" + "(" + productId + ") data" + " have been deleted successfully.";
	}
}
