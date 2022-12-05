
package com.kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Product;

public interface ProductRepositories extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);//where 
	//select * from products where name like 'rum%'
	List<Product> findByNameContainingIgnoreCase(String name);
	
	
	


}
