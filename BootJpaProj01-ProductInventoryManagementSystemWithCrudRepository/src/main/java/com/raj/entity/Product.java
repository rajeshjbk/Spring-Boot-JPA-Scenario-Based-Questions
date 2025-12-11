package com.raj.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Product_Details")
public class Product {

	@Column(name = "PID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Column(name = "PNAME",length = 30)
	@NonNull
	private String name;
	
	@Column(name = "CATEGORY",length = 30)
	@NonNull
	private String category;
	
	@Column(name = "PRICE")
	@NonNull
	private Double price;
	
	@Column(name = "STOCK")
	@NonNull
	private Integer stock;
	
}
