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

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Student_Records")
public class Student {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "Roll_No", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer rollNo;
	
	@Column(length = 30)
	@NonNull
	private String name;
	
	@Column(length = 30)
	@NonNull
	private String studentClass;
	
	@NonNull
	private Double marks;
	
	@Column(length = 30)
	@NonNull
	private String result;
	
	@Column(length = 30)
	@NonNull
	private String examYear;
	
}
