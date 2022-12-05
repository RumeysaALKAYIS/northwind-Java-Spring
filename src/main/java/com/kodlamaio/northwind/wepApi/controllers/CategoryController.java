package com.kodlamaio.northwind.wepApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstacts.CategoriesServices;
import com.kodlamaio.northwind.business.requests.CreatedCategoryRequest;
import com.kodlamaio.northwind.business.requests.UpdateCategoryResquest;
import com.kodlamaio.northwind.business.responses.CreateCategoryResponse;
import com.kodlamaio.northwind.business.responses.GetAllCategoriesResponses;
import com.kodlamaio.northwind.business.responses.GetAllCategoryResponses;
import com.kodlamaio.northwind.business.responses.GetCategoryResponse;
import com.kodlamaio.northwind.business.responses.UpdateCategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

	private CategoriesServices services;

	@GetMapping("/getall")
	public List<GetAllCategoriesResponses> getall() {
		return this.services.getAll();
	}

	@PostMapping("/add")
	public CreateCategoryResponse add(@RequestBody CreatedCategoryRequest categoryRequest) {
		return this.services.add(categoryRequest);
	}

	@GetMapping("/getbyname/{name}")
	public List<GetAllCategoryResponses> getByName(@PathVariable String name) {
		return this.services.getByName(name);
	}

	@GetMapping("/getbyid/{id}")
	public GetCategoryResponse getById(@PathVariable int id) {
		return this.services.getById(id);
	}

	@PutMapping("/update")
	public UpdateCategoryResponse update(@RequestBody UpdateCategoryResquest updateCategoryRequest) {
		return this.services.update(updateCategoryRequest);
	}

	@DeleteMapping("/delete/{id}")
	public void delete( @PathVariable int id) {
		this.services.delete(id);
	}

}
