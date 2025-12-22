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
@Table(name = "STUDENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "STU_ID",initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer studentId;
	@Column(name = "SNAME", length = 30)
	@NonNull
	private String name;
	
	@Column(name = "COURSE", length = 30)
	@NonNull
	private String course;
	
	@Column(name = "MARKS")
	@NonNull
	private Double marks;
	
	@Column(name = "GRADE", length = 30)
	@NonNull
	private String grade;
	
}
