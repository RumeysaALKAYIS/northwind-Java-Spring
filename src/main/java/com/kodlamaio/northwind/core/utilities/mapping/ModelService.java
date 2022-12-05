package com.kodlamaio.northwind.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelService {
	ModelMapper forResponse();

	ModelMapper forRequest();
}
