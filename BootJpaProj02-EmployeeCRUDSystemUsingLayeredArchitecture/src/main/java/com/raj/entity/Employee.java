package com.raj.entity;

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
@Table(name = "Employee_Details")
public class Employee {

	@Column(name = "ID")
	@Id
//	@SequenceGenerator(name="seq1",sequenceName = "ID_SEQ", initialValue = 1000,allocationSize = 1)
//	@GeneratedValue(generator ="seq1",strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="NAME",length = 30)
	@NonNull
	private String name;

	@Column(name="DEPT",length = 30)
	@NonNull
	private String department;

	@Column(name="SAL")
	@NonNull
	private Double salary;
	
}
