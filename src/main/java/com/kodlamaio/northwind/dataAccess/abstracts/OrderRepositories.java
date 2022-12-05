package com.kodlamaio.northwind.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Order;

public interface OrderRepositories extends JpaRepository<Order, Integer> {

	List<Order> findByName(String name);
	List<Order> findByLocalDate(LocalDate localDate);

	List<Order> findByLocalDateBetween(LocalDate start, LocalDate end);

	
	
}
