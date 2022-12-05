package com.kodlamaio.northwind.entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "unitPrice")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private int unitsInStock;

	// Bir categorynın cok ürünü olabilir one to many ilişkisi vardır
	@ManyToOne //
	@JoinColumn(name = "category_id") // product
	private Category category;// (mappedBy = "category")

}
