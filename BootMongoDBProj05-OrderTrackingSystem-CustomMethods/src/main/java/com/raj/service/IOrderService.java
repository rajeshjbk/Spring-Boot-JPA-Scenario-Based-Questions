package com.raj.service;

import java.util.List;

import com.raj.document.Order;

public interface IOrderService {

	String saveOrder(Order order);
	List<Order> findByStatus(String status);
	List<Order> findByCity(String city);
	
	List<Order> findByAmountGreaterThan(Double amount);
	List<Order> findByCityAndStatus(String city, String status);
	
	List<Order> findOrdersSortedByAmount();
	List<Order> findLatestOrdersByDate();
	
	Double totalRevenue();
	String trackOrderProgress(String id);
	
	List<Order> allOrdersSummaries();
	
}
