package com.raj.service;
import java.util.List;

import com.raj.document.Product;

public interface IProductService {

	String saveProduct(Product prod);
	List<Product> findByCategory(String category);
	List<Product> findByBrand(String brand);
	List<Product> findByStockGreaterThan(Integer stock);
	List<Product> findByAvailable(Boolean available);
	String updateStockByPid(String id,Integer stock);
	String updatePriceByBrand(String brand, Double price);
	String deleteByCategory(String category);
}
