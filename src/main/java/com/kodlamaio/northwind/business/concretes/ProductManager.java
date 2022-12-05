package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstacts.ProductServices;
import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.requests.UpdateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductsResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;
import com.kodlamaio.northwind.business.responses.UpdateProductResponse;
import com.kodlamaio.northwind.core.utilities.mapping.ModelService;
import com.kodlamaio.northwind.dataAccess.abstracts.ProductRepositories;
import com.kodlamaio.northwind.entities.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductManager implements ProductServices {

	private ProductRepositories productRepositories;
	private ModelService modelService;

	@Override
	public List<GetAllProductsResponse> getAll() {
		List<Product> products = this.productRepositories.findAll();
		List<GetAllProductsResponse> responses = new ArrayList<>();

		for (Product product : products) {
			GetAllProductsResponse itemresponse = new GetAllProductsResponse();
			itemresponse.setId(product.getId());
			itemresponse.setName(product.getName());
			itemresponse.setUnitPrice(product.getUnitPrice());
			itemresponse.setUnitsInStock(product.getUnitsInStock());
			itemresponse.setCategoryName(product.getCategory().getName());
			responses.add(itemresponse);
		}
		return responses;
	}

	@Override
	public CreateProductResponse add(CreateProductRequest createdProductRequests) {
		Product product = this.modelService.forRequest().map(createdProductRequests, Product.class);
		product.setId(0);
		this.productRepositories.save(product);
		CreateProductResponse createProductResponse = this.modelService.forResponse().map(product,
				CreateProductResponse.class);

		return createProductResponse;
	}

	@Override
	public List<GetAllProductsResponse> getByName(String name) {

		List<GetAllProductsResponse> responses = new ArrayList<>();

		List<Product> products = productRepositories.findByName(name);
		for (Product product : products) {
			GetAllProductsResponse itemResponse = new GetAllProductsResponse();
			itemResponse.setId(product.getId());
			itemResponse.setName(product.getName());
			itemResponse.setUnitPrice(product.getUnitPrice());
			itemResponse.setCategoryName(name);
			responses.add(itemResponse);
		}
		return responses;
	}

	@Override
	public GetProductResponse getById(int id) {

		Product product = this.productRepositories.findById(id).get();
		GetProductResponse responses = this.modelService.forResponse().map(product, GetProductResponse.class);

		return responses;
	}

	@Override
	public UpdateProductResponse update(UpdateProductRequest updateProductRequest) {

		Product product = this.modelService.forRequest().map(updateProductRequest, Product.class);
		this.productRepositories.save(product);
		UpdateProductResponse productResponse = this.modelService.forResponse().map(product,
				UpdateProductResponse.class);
		return productResponse;
	}

	@Override
	public void delete(int id) {
		this.productRepositories.deleteById(id);
	}

	@Override
	public List<GetAllProductsResponse> findByNameContainingIgnoreCase(String name) {
		List<Product> products = this.productRepositories.findByNameContainingIgnoreCase(name);
		List<GetAllProductsResponse> allProductsResponses = new ArrayList<>();

		for (Product product : products) {
			GetAllProductsResponse itemResponse = new GetAllProductsResponse();
			itemResponse.setId(product.getId());
			itemResponse.setName(product.getName());
			itemResponse.setUnitPrice(product.getUnitPrice());
			itemResponse.setCategoryName(product.getCategory().getName());
			allProductsResponses.add(itemResponse);
		}

		return allProductsResponses;
	}

}
