package com.raj.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "AM_OTM_AUTHOR")
public class Author {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "AUTHOR_ID_SEQ", initialValue = 101, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer aid;
	
	@Column(length = 30)
	@NonNull
	private String name;
	
	@Column(length = 30)
	@NonNull
	private String country;
	
	public Author() {
		
		System.out.println("Author:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Author [aid=" + aid + ", name=" + name + ", country=" + country + "]";
	}
	
}
