package com.kodlamaio.northwind.business.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrderResponse {

	private int id;
	private String name;
	private int employoeId;
	private LocalDate localDate;

}
