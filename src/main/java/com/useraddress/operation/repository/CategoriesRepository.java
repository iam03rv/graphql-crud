package com.useraddress.operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useraddress.operation.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
