package com.raj.service;

import java.util.List;
import java.util.Optional;

import com.raj.entity.Product;

public interface IProductService {

	String saveProduct(Product product);
	
	Optional<Product> getProductById(Integer id);

	List<Product>getAllProducts();

}
