package com.raj.entity;

import java.time.LocalDate;
import java.util.Date;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Employee_Details11")
public class Employee {

	@Column(name = "ID")
	@Id
	@SequenceGenerator(name="e_seq",sequenceName = "EID_SEQ", initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator ="e_seq",strategy = GenerationType.SEQUENCE)
	private Integer empId;

	@Column(name="NAME",length = 30)
	@NonNull
	private String eName;

	@Column(name="DEPT",length = 30)
	@NonNull
	private String department;

	@Column(name="SAL")
	@NonNull
	private Double salary;
	
	@Column(name = "DATE_OF_JOINING")
	@NonNull
	private LocalDate dateOfJoining;
	
}
