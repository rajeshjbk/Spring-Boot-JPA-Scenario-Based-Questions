package com.raj.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Document(collection = "ORDER_DOCUMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {

	@Id
	private String orderId;
	
	@NonNull
	private String customerName;
	@NonNull
	private String  city;
	@NonNull
	private Double amount;
	@NonNull
	private String status;
	@NonNull
	private Date date;
	
}
