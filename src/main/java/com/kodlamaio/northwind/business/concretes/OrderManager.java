package com.kodlamaio.northwind.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstacts.OrdersServices;
import com.kodlamaio.northwind.business.requests.BetweenDayRequest;
import com.kodlamaio.northwind.business.requests.CreatedOrderRequest;
import com.kodlamaio.northwind.business.requests.UpdateOrderRequest;
import com.kodlamaio.northwind.business.responses.CreatedOrderResponse;
import com.kodlamaio.northwind.business.responses.GetAllOrderResponse;
import com.kodlamaio.northwind.business.responses.GetOrderResponse;
import com.kodlamaio.northwind.business.responses.UpdateOrderResponse;
import com.kodlamaio.northwind.core.utilities.mapping.ModelService;
import com.kodlamaio.northwind.dataAccess.abstracts.OrderRepositories;
import com.kodlamaio.northwind.entities.Order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderManager implements OrdersServices {

	private OrderRepositories orderRepositories;
	private ModelService modelService;

	@Override
	public List<GetAllOrderResponse> getAll() {
		List<Order> orders = this.orderRepositories.findAll();
		List<GetAllOrderResponse> allOrderResponses = new ArrayList<>();

		for (Order order : orders) {
			GetAllOrderResponse response = this.modelService.forResponse().map(order, GetAllOrderResponse.class);

			allOrderResponses.add(response);

		}

		return allOrderResponses;
	}

	@Override
	public CreatedOrderResponse add(CreatedOrderRequest createdOrderRequest) {
		Order order = this.modelService.forRequest().map(createdOrderRequest, Order.class);
		order.setId(0);

		this.orderRepositories.save(order);

		CreatedOrderResponse createdOrderResponse = this.modelService.forResponse().map(order,
				CreatedOrderResponse.class);

		return createdOrderResponse;

	}

	@Override
	public GetOrderResponse getbyId(int id) {

		Order order = this.orderRepositories.findById(id).get();
		GetOrderResponse getOrderResponse = this.modelService.forResponse().map(order, GetOrderResponse.class);
		return getOrderResponse;

	}

	@Override
	public List<GetOrderResponse> getByName(String name) {
		List<GetOrderResponse> getOrderResponses = new ArrayList<>();
		GetOrderResponse getOrderResponse = new GetOrderResponse();
		List<Order> orders = this.orderRepositories.findByName(name);
		for (Order order : orders) {
			getOrderResponse.setId(order.getId());
			getOrderResponse.setName(order.getName());
			getOrderResponse.setLocalDate(order.getLocalDate());
			getOrderResponse.setEmployoeid(order.getEmployoe().getId());
			getOrderResponses.add(getOrderResponse);
		}

		return getOrderResponses;
	}

	@Override
	public UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest) {

		Order order = this.modelService.forRequest().map(updateOrderRequest, Order.class);
		this.orderRepositories.save(order);
		UpdateOrderResponse orderResponse = this.modelService.forResponse().map(order, UpdateOrderResponse.class);

		return orderResponse;
	}

	@Override
	public List<GetAllOrderResponse> getByBetweenDay(BetweenDayRequest betweenDayRequest) {
		LocalDate beforeDay = stringToLocalDate(betweenDayRequest.getBeforeDay());
		LocalDate afterDay = stringToLocalDate(betweenDayRequest.getAfterDay());

		List<Order> orders = this.orderRepositories.findByLocalDateBetween(beforeDay, afterDay);

		List<GetAllOrderResponse> allOrderResponses = new ArrayList<>();

		for (Order order : orders) {

			GetAllOrderResponse allOrderResponse = new GetAllOrderResponse();
			// allOrderResponse.setEmployoeId(order.getEmployoe().getId());
			allOrderResponse.setId(order.getId());
			allOrderResponse.setLocalDate(order.getLocalDate());
			allOrderResponse.setName(order.getName());

			allOrderResponses.add(allOrderResponse);
		}
		return allOrderResponses;
	}

	@Override
	public void delete(int id) {

		this.orderRepositories.deleteById(id);
	}

	private LocalDate stringToLocalDate(String change) {
		return LocalDate.parse(change);

	}

}
