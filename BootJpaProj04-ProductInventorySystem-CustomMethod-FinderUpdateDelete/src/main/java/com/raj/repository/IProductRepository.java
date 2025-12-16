package com.raj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.raj.document.Product;

public interface IProductRepository extends MongoRepository<Product, String> {

	List<Product> findByCategory(String category);
	List<Product> findByBrand(String brand);
	
	List<Product> findByStockGreaterThan(Integer stock);
	List<Product> findByAvailable(Boolean available);
	
	@Query("{ '_id': ?0 }")
	@Update("{ '$set': { 'stock': ?1 } }")
	long updateStockByPid(String id, Integer stock);
	
	@Query("{ 'brand': ?0 }")
	@Update("{ '$set': { 'price': ?1 } }")
	long updatePriceByBrand(String brand, Double price);
	
	void deleteByCategory(String category);
	
}
