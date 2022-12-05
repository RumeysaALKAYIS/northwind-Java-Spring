package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstacts.EmployoeServices;
import com.kodlamaio.northwind.business.requests.CreatedEmployoeRequest;
import com.kodlamaio.northwind.business.requests.UpdatedEmployoeRequest;
import com.kodlamaio.northwind.business.responses.CreatedEmployoeResponse;
import com.kodlamaio.northwind.business.responses.GetAllEmployoeResponses;
import com.kodlamaio.northwind.business.responses.UpdatedEmployoeResponse;
import com.kodlamaio.northwind.core.utilities.mapping.ModelService;
import com.kodlamaio.northwind.dataAccess.abstracts.EmployeeRepositories;
import com.kodlamaio.northwind.entities.Employoe;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployoeManager implements EmployoeServices {

	private EmployeeRepositories employeeRepositories;
	private ModelService modelService;

	@Override
	public List<GetAllEmployoeResponses> getAll() {
		List<Employoe> employoes = this.employeeRepositories.findAll();
		List<GetAllEmployoeResponses> responses=new ArrayList<>();
		
		for (Employoe employoe : employoes) {
			GetAllEmployoeResponses itemResponses=this.modelService.forResponse().map(employoe, GetAllEmployoeResponses.class);
			responses.add(itemResponses);
		}

		return responses;
	}

	@Override
	public CreatedEmployoeResponse add(CreatedEmployoeRequest createdEmployoeRequest) {

		Employoe employoe = this.modelService.forRequest().map(createdEmployoeRequest, Employoe.class);

		this.employeeRepositories.save(employoe);

		return this.modelService.forResponse().map(employoe, CreatedEmployoeResponse.class);

	}

	@Override
	public UpdatedEmployoeResponse update(UpdatedEmployoeRequest employoeRequest) {
		
		Employoe employoe=this.modelService.forRequest().map(employoeRequest, Employoe.class);
		this.employeeRepositories.save(employoe);
		
		return this.modelService.forRequest().map(employoe, UpdatedEmployoeResponse.class);
	}

	@Override
	public void delete(int id) {
		this.employeeRepositories.deleteById(id);
		
	}

}
