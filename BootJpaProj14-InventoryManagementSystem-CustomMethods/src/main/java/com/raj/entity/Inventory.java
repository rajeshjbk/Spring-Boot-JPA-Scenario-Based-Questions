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
@Table(name="INVENTORY_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Inventory {

	@Id
	@SequenceGenerator(name = "s1",sequenceName = "Product_Id_Seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "s1", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NonNull
	private String productName;
	@NonNull
	private String category;
	@NonNull
	private Integer quantity;
	@NonNull
	private Double price;
	@NonNull
	private Boolean available;
}
