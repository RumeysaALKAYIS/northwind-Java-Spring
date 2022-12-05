package com.kodlamaio.northwind.business.requests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
	private int id;
	private LocalDate localDate;
	private String name;
	private int employeId;

}
