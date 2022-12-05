package com.kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Employoe;

public interface EmployeeRepositories extends JpaRepository<Employoe, Integer> {

}
