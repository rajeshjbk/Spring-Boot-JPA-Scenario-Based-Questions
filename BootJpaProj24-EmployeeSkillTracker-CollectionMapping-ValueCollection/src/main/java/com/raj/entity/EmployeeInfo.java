package com.raj.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "CLM_EMPLOYEE_INFO")
public class EmployeeInfo {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "EID_SEQ", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Long empId;
	
	@Column(length = 30)
	@NonNull
	private String empName;
	
	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_SKILLS", joinColumns = @JoinColumn(referencedColumnName = "EMPID"))
	@Column(name = "EMP_SKILLS")
	@NonNull
	private List<String> skills;
	
	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_CERTIFICATION", joinColumns = @JoinColumn(referencedColumnName = "EMPID"))
	@Column(name = "EMP_CERTIFICATION")
	@NonNull
	private Set<String> certifications;
	
	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_PROJECT_RATING", joinColumns = @JoinColumn(referencedColumnName = "EMPID"))
	@Column(name = "EMP_PROJECT_RATING")
	@NonNull
	private Map<String, Double> projectRatings;
}
