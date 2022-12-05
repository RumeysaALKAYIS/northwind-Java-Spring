package com.kodlamaio.northwind.business.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

	@NotEmpty(message = "Can't be Emty")
	private String name;
	@NotEmpty(message ="Can't be Emty" )
	private double unitPrice;
	@NotNull
	private int categoryId;
	@NotNull
	private int unitsInStock;
}
