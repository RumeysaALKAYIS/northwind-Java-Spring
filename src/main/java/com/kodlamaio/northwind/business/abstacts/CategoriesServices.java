package com.kodlamaio.northwind.business.abstacts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.requests.CreatedCategoryRequest;
import com.kodlamaio.northwind.business.requests.UpdateCategoryResquest;
import com.kodlamaio.northwind.business.responses.CreateCategoryResponse;
import com.kodlamaio.northwind.business.responses.GetAllCategoriesResponses;
import com.kodlamaio.northwind.business.responses.GetAllCategoryResponses;
import com.kodlamaio.northwind.business.responses.GetCategoryResponse;
import com.kodlamaio.northwind.business.responses.UpdateCategoryResponse;

@Service
public interface CategoriesServices {

	List<GetAllCategoriesResponses> getAll();

	CreateCategoryResponse add(CreatedCategoryRequest createdCategoryRequest);

	List<GetAllCategoryResponses> getByName(String name);

	GetCategoryResponse getById(int id);

	UpdateCategoryResponse update(UpdateCategoryResquest updateCategoryRequest);

	void delete(int id);
}
