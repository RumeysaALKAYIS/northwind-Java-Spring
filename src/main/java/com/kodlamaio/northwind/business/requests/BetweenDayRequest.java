package com.kodlamaio.northwind.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BetweenDayRequest {

	private String beforeDay;
	private String afterDay;
}
