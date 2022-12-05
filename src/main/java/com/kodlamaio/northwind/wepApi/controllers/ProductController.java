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

import com.kodlamaio.northwind.business.abstacts.ProductServices;
import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.requests.UpdateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductsResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;
import com.kodlamaio.northwind.business.responses.UpdateProductResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

	private ProductServices services;

	@GetMapping("/getall")
	public List<GetAllProductsResponse> getAll() {

		return services.getAll();
	}

	@PostMapping("/add")
	public CreateProductResponse add(@RequestBody CreateProductRequest createdProductRequests) {
		return services.add(createdProductRequests);

	}

	@GetMapping("/getbyname/{name}")
	public List<GetAllProductsResponse> getByName(@PathVariable String name) {
		return services.getByName(name);
	}

	@GetMapping("/getbyid/{id}")
	public GetProductResponse getById(@PathVariable int id) {
		return services.getById(id);
	}

	@PutMapping("/update")
	public UpdateProductResponse update(@RequestBody UpdateProductRequest updateProductRequest) {
		return services.update(updateProductRequest);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.services.delete(id);
	}

	@GetMapping("/findByNameContainingIgnoreCase/{name}")
	public List<GetAllProductsResponse> findByNameStartsWith(@PathVariable String name) {
		return this.services.findByNameContainingIgnoreCase(name);
	}

}
