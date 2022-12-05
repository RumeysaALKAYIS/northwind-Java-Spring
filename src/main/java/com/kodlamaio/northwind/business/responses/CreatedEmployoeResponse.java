package com.kodlamaio.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CreatedEmployoeResponse {
	private int id;
	private String name;

	private String lastName;

	private double salary;
}
