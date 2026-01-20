package com.raj.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MTM_EMPLOYEE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "EMPID_SEQ",initialValue = 101,allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empId;

	@Column(length = 40)
	@NonNull
	private String empName;

	@NonNull
	private Double salary;

	@Column(length = 40)
	@NonNull
	private String designation;

	@NonNull
	@ManyToMany(targetEntity = Project.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "MTM_EMPLOYEES_PROJECTS",
	joinColumns = @JoinColumn(name="EMPLOYEE_ID",referencedColumnName = "empId"),  //owning side FK column
	inverseJoinColumns = @JoinColumn(name="PROJECT_ID",referencedColumnName = "projId"))  //non-owning side FK column
	private Set<Project> projects = new HashSet<>();

	public Employee(){

		System.out.println("Employee:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", designation="
				+ designation + "]";
	}
}
