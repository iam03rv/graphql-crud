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

import com.useraddress.operation.model.Categories;
import com.useraddress.operation.repository.CategoriesRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoriesRepository categoriesRepository;
//	@Autowired
//	private CategoriesRepository categoriesRepository;
//	Categories category = categoriesRepository.findyId(1).get();
//	System.out.println(category.getProducts().size());
	@PostMapping("/categories")
	public Categories createCustomer(@RequestBody Categories categories) {
		return categoriesRepository.save(categories);
	}

	@GetMapping("/categories")
	public List<Categories> getCustomers() {
		return categoriesRepository.findAll();
	}

	@GetMapping("/categories/{CATEGORY_ID}")
	public Categories getCustomer(@PathVariable(value = "CATEGORY_ID") long id) {
		return categoriesRepository.findById(id).get();
	}

	@PutMapping("/categories/{CATEGORY_ID}")
	public Categories updateCategory(@PathVariable(value = "CATEGORY_ID") Long categoryId,
			@RequestBody Categories category) {
		Categories c = categoriesRepository.findById(categoryId).get();
		c.setName(category.getName());
		c.setProducts(category.getProducts());
		return categoriesRepository.save(c);
	}

	@DeleteMapping("/categories")
	public String deleteAllCategories() {
		categoriesRepository.deleteAll();
		return "All categories have been deleted successfully.";
	}

	@DeleteMapping("/categories/{CATEGORY_ID}")
	public String deleteCategory(@PathVariable (value = "CATEGORY_ID") Long categoryId) {
		categoriesRepository.deleteById(categoryId);
		return "the category" + "(" + categoryId + ") data" + " have been deleted successfully.";
	}
}
