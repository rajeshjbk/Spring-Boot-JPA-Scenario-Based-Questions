package com.raj.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderMailDTO {

	private String to;
	private String subject;
	private String message;
	
}
