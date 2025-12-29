package com.raj.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
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
@Table(name="PRODUCT_INFO")
public class Product {

	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "prod_id", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer productId;
	
	@NonNull
	private String productName;
	
	@NonNull
	private Double price;
	
	@Version
	private Integer version;
	
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime createdDate; 
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime lastModifiedDate;
	
}
