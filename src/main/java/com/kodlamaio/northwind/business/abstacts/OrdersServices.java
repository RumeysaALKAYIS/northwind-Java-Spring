package com.kodlamaio.northwind.business.abstacts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.requests.BetweenDayRequest;
import com.kodlamaio.northwind.business.requests.CreatedOrderRequest;
import com.kodlamaio.northwind.business.requests.UpdateOrderRequest;
import com.kodlamaio.northwind.business.responses.CreatedOrderResponse;
import com.kodlamaio.northwind.business.responses.GetAllOrderResponse;
import com.kodlamaio.northwind.business.responses.GetOrderResponse;
import com.kodlamaio.northwind.business.responses.UpdateOrderResponse;

@Service
public interface OrdersServices {

	List<GetAllOrderResponse> getAll();

	CreatedOrderResponse add(CreatedOrderRequest createdOrderRequest);

	GetOrderResponse getbyId(int id);

	List<GetOrderResponse> getByName(String name);

	UpdateOrderResponse update(UpdateOrderRequest updateOrderRequest);

	void delete(int id);

	List<GetAllOrderResponse> getByBetweenDay(BetweenDayRequest betweenDayRequest);

}
