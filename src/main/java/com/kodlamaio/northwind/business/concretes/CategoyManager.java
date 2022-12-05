package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstacts.CategoriesServices;
import com.kodlamaio.northwind.business.requests.CreatedCategoryRequest;
import com.kodlamaio.northwind.business.requests.UpdateCategoryResquest;
import com.kodlamaio.northwind.business.responses.CreateCategoryResponse;
import com.kodlamaio.northwind.business.responses.GetAllCategoriesResponses;
import com.kodlamaio.northwind.business.responses.GetAllCategoryResponses;
import com.kodlamaio.northwind.business.responses.GetCategoryResponse;
import com.kodlamaio.northwind.business.responses.UpdateCategoryResponse;
import com.kodlamaio.northwind.core.utilities.mapping.ModelService;
import com.kodlamaio.northwind.dataAccess.abstracts.CategoryRepositories;
import com.kodlamaio.northwind.entities.Category;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoyManager implements CategoriesServices {

	private CategoryRepositories repositories;
	private ModelService modelService;

	@Override
	public List<GetAllCategoriesResponses> getAll() {
		List<Category> categories = repositories.findAll();
		List<GetAllCategoriesResponses> responses = new ArrayList<>();

		for (Category category : categories) {
			GetAllCategoriesResponses itemResponse = new GetAllCategoriesResponses();
			itemResponse.setId(category.getId());
			itemResponse.setName(category.getName());
			responses.add(itemResponse);
		}
		return responses;
	}

	@Override
	public List<GetAllCategoryResponses> getByName(String name) {

		List<GetAllCategoryResponses> responses = new ArrayList<>();

		List<Category> categories = repositories.findByName(name);

		for (Category category : categories) {
			GetAllCategoryResponses itemResponse = new GetAllCategoryResponses();
			itemResponse.setId(category.getId());
			itemResponse.setName(category.getName());
			responses.add(itemResponse);
		}

		return responses;
	}

	@Override
	public GetCategoryResponse getById(int id) {
		Category category = this.repositories.findById(id).get();
		GetCategoryResponse response = this.modelService.forResponse().map(category, GetCategoryResponse.class);

		return response;
	}

	@Override
	public CreateCategoryResponse add(CreatedCategoryRequest createdCategoryRequest) {
		Category category = this.modelService.forRequest().map(createdCategoryRequest, Category.class);
		category.setId(0);
		this.repositories.save(category);
		CreateCategoryResponse categoryResponse = this.modelService.forResponse().map(category,
				CreateCategoryResponse.class);
		return categoryResponse;
	}

	@Override
	public UpdateCategoryResponse update(UpdateCategoryResquest updateCategoryRequest) {

		Category category = this.modelService.forRequest().map(updateCategoryRequest, Category.class);

		this.repositories.save(category);

		UpdateCategoryResponse updateCategoryResponse = this.modelService.forResponse().map(category,
				UpdateCategoryResponse.class);

		return updateCategoryResponse;
	}

	@Override
	public void delete(int id) {
		Category category = this.repositories.findById(id).get();
		this.repositories.delete(category);

	}

}
