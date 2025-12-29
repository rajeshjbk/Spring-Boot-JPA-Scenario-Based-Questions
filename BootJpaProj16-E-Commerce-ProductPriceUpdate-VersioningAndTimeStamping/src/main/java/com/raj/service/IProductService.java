package com.raj.service;

import java.util.List;
import java.util.Optional;

import com.raj.entity.Product;

public interface IProductService {

	String addProduct(Product product);
	
	Optional<Product> fetchProductById(int id);
	
	List<Product> showAllProducts();
	
	String updateProductPrice(int id, double price);
	
	String deleteProduct(int id);
}
