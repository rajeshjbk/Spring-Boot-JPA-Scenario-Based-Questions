package com.raj.entity;


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
@Table(name = "COURSE_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

	@Id
	@SequenceGenerator(name = "c_seq",sequenceName = "CourseId_Seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "c_seq", strategy = GenerationType.SEQUENCE)
	private Integer courseId;
	
	@NonNull
	private String courseName;
	@NonNull
	private String instructor;
	@NonNull
	private Double fee;
	@NonNull
	private Integer durartion;
	@NonNull
	private Boolean available;
	
}
