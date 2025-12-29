package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
