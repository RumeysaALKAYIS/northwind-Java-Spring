package com.kodlamaio.northwind.business.abstacts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.requests.CreatedEmployoeRequest;
import com.kodlamaio.northwind.business.requests.UpdatedEmployoeRequest;
import com.kodlamaio.northwind.business.responses.CreatedEmployoeResponse;
import com.kodlamaio.northwind.business.responses.GetAllEmployoeResponses;
import com.kodlamaio.northwind.business.responses.UpdatedEmployoeResponse;

@Service
public interface EmployoeServices {

	List<GetAllEmployoeResponses> getAll();

	CreatedEmployoeResponse add(CreatedEmployoeRequest createdEmployoeRequest);
	
	UpdatedEmployoeResponse update(UpdatedEmployoeRequest employoeRequest);
	
	void delete(int id);

}
