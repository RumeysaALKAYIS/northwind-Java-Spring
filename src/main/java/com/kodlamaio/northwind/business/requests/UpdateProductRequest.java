package com.kodlamaio.northwind.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

	private int id;
	private String name;
	private double unitPrice;
	private int unitsInStock;
	private int categoryId;

}
