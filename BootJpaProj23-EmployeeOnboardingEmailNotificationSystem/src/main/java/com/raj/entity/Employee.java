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
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Employee_Records")
public class Employee {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "EMP_ID",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 40)
	@NonNull
	private String name;
	
	@Column(length = 40)
	@NonNull
	private String email;
	
	@Column(length = 40)
	@NonNull
	private String department;
	
	@NonNull
	private Double salary;
	
	@NonNull
	private LocalDate dateOfJoining;
}
