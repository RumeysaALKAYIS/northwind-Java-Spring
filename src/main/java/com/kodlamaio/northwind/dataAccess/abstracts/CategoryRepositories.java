package com.kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Category;

public interface CategoryRepositories extends JpaRepository<Category, Integer> {

	List<Category> findByName(String name);
}
