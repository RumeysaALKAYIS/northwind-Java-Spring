package com.kodlamaio.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {

	private int id;
	private String name;
	private double unitPrice;
	private int unitsInStock;
	private int categoryId;
}
