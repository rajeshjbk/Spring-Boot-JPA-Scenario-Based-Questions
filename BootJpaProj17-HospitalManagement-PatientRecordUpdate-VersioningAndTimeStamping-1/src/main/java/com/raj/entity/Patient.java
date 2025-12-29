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
public class Patient {

	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "patient_id", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer patientId;
	
	@NonNull
	@Column(length = 50)
	private String patientName;
	
	@NonNull
	@Column(length = 50)
	private String diagnosis;
	
	@NonNull
	@Column(length = 50)
	private String treatment;
	
	@Version
	private Integer version;
	
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime updatedAt;
}
