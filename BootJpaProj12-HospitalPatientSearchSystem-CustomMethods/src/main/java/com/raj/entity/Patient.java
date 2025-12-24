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
@Table(name = "PATIENT_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Patient {

	@Id
	@SequenceGenerator(name = "P_SEQ1", sequenceName = "PID_SEQ1",initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "P_SEQ1", strategy = GenerationType.SEQUENCE)
	private Integer patientID;
	
	@Column(name = "PATIENT_NAME")
	@NonNull
	private String patientName;
	
	@Column(name = "DISEASE")
	@NonNull
	private String disease;
	
	@Column(name = "DOCTOR_NAME")
	@NonNull
	private String doctorName;
	
	@Column(name = "AGE")
	@NonNull
	private Integer age;
	
	@Column(name = "ADMISSION_DATE")
	@NonNull
	private LocalDate admissionDate;

	@Column(name = "DISCHARGED")
	@NonNull
	private Boolean discharged;
	
}
