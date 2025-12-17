package com.raj.service;

import java.util.List;
import java.util.Optional;

import com.raj.entity.Product;

public interface IProductService {

	String addProduct(Product prod);
	String addMultipleProducts(List<Product> list);
	Optional<Product> findById(Integer id);
	Iterable<Product> showAllProducts();
	String updateProductPrice(Integer id, Double newPrice);
	String deleteProductById(Integer id);
	String deleteAllProducts();
}
