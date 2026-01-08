package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {

}
