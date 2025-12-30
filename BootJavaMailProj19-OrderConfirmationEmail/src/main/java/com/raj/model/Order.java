package com.raj.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

	private String orderId;
	private String customerEmail;
	private String productName;
	private Integer quantity;
	private Double totalAmount;
	
}
