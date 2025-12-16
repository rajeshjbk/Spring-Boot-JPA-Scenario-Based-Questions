package com.raj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.raj.document.Order;

public interface IOrderRepository extends MongoRepository<Order, String> {

	List<Order> findByStatus(String status);
	List<Order> findByCity(String city);
	
	List<Order> findByAmountGreaterThan(Double amount);
	List<Order> findByCityAndStatus(String city, String status);
	
}
