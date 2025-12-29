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
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Bank_Details")
public class Account {

	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "acno_id", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer accountId;
	
	@NonNull
	@Column(length = 30)
	private String holderName;
	
	@NonNull
	@Column(length = 30)
	private String addrs;
	
	@NonNull
	private Double balance;
	
	@Version
	private Integer version;
	
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime updatedAt;
	
}
