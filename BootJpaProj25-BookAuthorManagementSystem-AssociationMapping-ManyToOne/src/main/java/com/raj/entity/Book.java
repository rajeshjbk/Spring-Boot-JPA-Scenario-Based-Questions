package com.raj.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AM_OTM_BOOKS")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Book {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "BOOK_ID_SEQ", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer bid;
	
	@Column(length = 30)
	@NonNull
	private String title;
	
	@Column(length = 30)
	@NonNull
	private String genre;
	
	
	@ManyToOne(targetEntity = Author.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "AUTHOR_ID", referencedColumnName = "AID")
	private Author author; //HAS-A property to build Many to One Association
	
	public Book() {
		
		System.out.println("Book:: 0-param constructor.");
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", genre=" + genre + ", author=" + author + "]";
	}
}
