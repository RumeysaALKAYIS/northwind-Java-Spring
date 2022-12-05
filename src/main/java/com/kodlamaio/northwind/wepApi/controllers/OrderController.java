package com.kodlamaio.northwind.wepApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstacts.OrdersServices;
import com.kodlamaio.northwind.business.requests.BetweenDayRequest;
import com.kodlamaio.northwind.business.requests.CreatedOrderRequest;
import com.kodlamaio.northwind.business.requests.UpdateOrderRequest;
import com.kodlamaio.northwind.business.responses.CreatedOrderResponse;
import com.kodlamaio.northwind.business.responses.GetAllOrderResponse;
import com.kodlamaio.northwind.business.responses.GetOrderResponse;
import com.kodlamaio.northwind.business.responses.UpdateOrderResponse;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrdersServices services;

	public OrderController(OrdersServices services) {
		super();
		this.services = services;
	}

	@GetMapping("/getall")
	public List<GetAllOrderResponse> getAll() {
		return this.services.getAll();
	}

	@PostMapping("/add")
	public CreatedOrderResponse add(@RequestBody CreatedOrderRequest createdOrderRequest) {
		return this.services.add(createdOrderRequest);
	}

	@GetMapping("/getbyid")
	public GetOrderResponse getbyId(@PathVariable int id) {

		return services.getbyId(id);
	}

	@PostMapping("/getbyname")
	public List<GetOrderResponse> getByName(@PathVariable String name) {
		return this.services.getByName(name);
	}

	@PutMapping("/update")
	public UpdateOrderResponse update(@RequestBody UpdateOrderRequest updateOrderRequest) {
	 	return this.services.update(updateOrderRequest);
	}
	@PostMapping("/getByBetweenDay")
	public 	List<GetAllOrderResponse> getByBetweenDay(@RequestBody BetweenDayRequest betweenDayRequest){
		return this.services.getByBetweenDay(betweenDayRequest);
	}

}
