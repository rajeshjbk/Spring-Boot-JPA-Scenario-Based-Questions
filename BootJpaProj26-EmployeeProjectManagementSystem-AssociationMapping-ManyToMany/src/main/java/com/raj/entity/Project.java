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
@Table(name = "MTM_PROJECT")
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Project {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "PROJID_SEQ",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer projId;
	
	@Column(length = 40)
	@NonNull
	private String projName;
	
	@Column(length = 40)
	@NonNull
	private String clientName;
	
	@NonNull
	private Double duration;
	
	@NonNull
	@ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "projects")
	private Set<Employee> employees = new HashSet<>();

	public Project() {
		
		System.out.println("Project:: 0-param constructor");
	}
	
	//toString
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", clientName=" + clientName + ", duration="
				+ duration + "]";
	}
}
