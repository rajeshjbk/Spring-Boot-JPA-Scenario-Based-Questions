package com.raj.repository;

import org.springframework.data.repository.CrudRepository;

import com.raj.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {

}
