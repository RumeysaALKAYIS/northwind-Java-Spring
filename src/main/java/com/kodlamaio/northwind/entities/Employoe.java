package com.kodlamaio.northwind.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="employoies")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employoe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "salary")
	private double salary;
	
	@OneToMany(mappedBy = "employoe")
	private List<Order>  orders;
	

}
