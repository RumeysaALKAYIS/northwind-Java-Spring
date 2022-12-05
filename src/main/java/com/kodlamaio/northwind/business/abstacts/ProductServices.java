package com.kodlamaio.northwind.business.abstacts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.requests.UpdateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductsResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;
import com.kodlamaio.northwind.business.responses.UpdateProductResponse;

@Service
public interface ProductServices {

	List<GetAllProductsResponse> getAll();

	CreateProductResponse add(CreateProductRequest createdProductRequests);

	List<GetAllProductsResponse> getByName(String name);

	GetProductResponse getById(int id);

	UpdateProductResponse update(UpdateProductRequest updateProductRequest);

	void delete(int id);

	List<GetAllProductsResponse> findByNameContainingIgnoreCase(String name);

}
