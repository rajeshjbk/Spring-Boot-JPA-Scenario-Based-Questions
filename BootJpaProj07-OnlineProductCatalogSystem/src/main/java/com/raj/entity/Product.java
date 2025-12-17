package com.raj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "PRODUCT_DETAIL")
public class Product {

	@Id
	@SequenceGenerator(name="p_seq",sequenceName = "ProductID_SEQ", initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator ="p_seq",strategy = GenerationType.SEQUENCE)
	private Integer productId;
	@NonNull
	private String productName;
	@NonNull
	private String brand;
	@NonNull
	private Double price;
	@NonNull
	private Integer stock;
	
}
