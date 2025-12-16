package com.raj.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "PRODUCT_DOCUMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {

	@Id
	private String pid;
	
	@NonNull
	private String name;
	@NonNull
	private String category;
	@NonNull
	private String brand;
	@NonNull
	private Double price;
	@NonNull
	private Integer stock;
	@NonNull
	private Boolean available;
	
}
