package com.raj.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
@Table(name = "ORDER_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {

	@Id
	@SequenceGenerator(name = "O_SEQ1", sequenceName = "OID_SEQ1",initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "O_SEQ1", strategy = GenerationType.SEQUENCE)
	private Integer orderId;
	
	@Column(name = "CUSTOMER_NAME")
	@NonNull
	private String customerName;
	
	@Column(name = "ORDER_STATUS")
	@NonNull
	private String orderStatus;
	
	@Column(name = "PAYMENT_MODE")
	@NonNull
	private String paymentMode;
	
	@Column(name = "TOTAL_AMOUNT")
	@NonNull
	private Double totalAmount;
	
	@Column(name = "ORDER_DATE")
	@NonNull
	private LocalDate orderDate;
	
}
