package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Author;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {
}