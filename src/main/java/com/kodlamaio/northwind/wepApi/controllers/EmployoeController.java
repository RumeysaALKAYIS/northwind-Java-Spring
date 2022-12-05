package com.kodlamaio.northwind.wepApi.controllers;

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

import com.kodlamaio.northwind.business.abstacts.EmployoeServices;
import com.kodlamaio.northwind.business.requests.CreatedEmployoeRequest;
import com.kodlamaio.northwind.business.requests.UpdatedEmployoeRequest;
import com.kodlamaio.northwind.business.responses.CreatedEmployoeResponse;
import com.kodlamaio.northwind.business.responses.GetAllEmployoeResponses;
import com.kodlamaio.northwind.business.responses.UpdatedEmployoeResponse;

@RestController
@RequestMapping("/api/employoeies")
public class EmployoeController {

	private EmployoeServices employoeServices;

	@Autowired
	public EmployoeController(EmployoeServices employoeServices) {
		super();
		this.employoeServices = employoeServices;
	}

	@GetMapping("/getall")
	public List<GetAllEmployoeResponses> getAll() {
		return employoeServices.getAll();
	}

	@PostMapping("/add")
	public CreatedEmployoeResponse add(@RequestBody CreatedEmployoeRequest createdEmployoeRequest) {
		return this.employoeServices.add(createdEmployoeRequest);
	}

	@PutMapping()
	public UpdatedEmployoeResponse update(@RequestBody UpdatedEmployoeRequest employoeRequest) {
		return this.employoeServices.update(employoeRequest);
	}

	@DeleteMapping()
	public void delete(@PathVariable int id) {
		this.employoeServices.delete(id);
	}

}
