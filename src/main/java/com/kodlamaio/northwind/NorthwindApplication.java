package com.kodlamaio.northwind;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.kodlamaio.northwind.core.utilities.logging.LoggerManager;

@SpringBootApplication
@EnableAspectJAutoProxy()
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}

	@Bean // Spring çalıştığı anda çalışır newler
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	public LoggerManager loggerManager() {

		return new LoggerManager();
	}

}
