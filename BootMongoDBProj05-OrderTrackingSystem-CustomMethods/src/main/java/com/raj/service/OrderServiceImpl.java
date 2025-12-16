package com.raj.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.raj.document.Order;
import com.raj.repository.IOrderRepository;
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepo;
	
	@Override
	public String saveOrder(Order order) {
		
		Order save = orderRepo.save(order);
		return "New Order is saved with Order ID: "+save.getOrderId();
	}

	@Override
	public List<Order> findByStatus(String status) {
		
		return orderRepo.findByStatus(status);
	}

	@Override
	public List<Order> findByCity(String city) {
		
		return orderRepo.findByCity(city);
	}

	@Override
	public List<Order> findByAmountGreaterThan(Double amount) {
		
		return orderRepo.findByAmountGreaterThan(amount);
	}

	@Override
	public List<Order> findByCityAndStatus(String city, String status) {
		
		return orderRepo.findByCityAndStatus(city, status);
	}

	@Override
	public List<Order> findOrdersSortedByAmount() {
		
		List<Order> all = orderRepo.findAll(Sort.by(Sort.Direction.DESC, "amount"));
		return all;
	}

	@Override
	public List<Order> findLatestOrdersByDate() {
		
		List<Order> all = orderRepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
		return all;	
	}

	@Override
	public Double totalRevenue() {
		
		return orderRepo.findAll()
                .stream()
                .mapToDouble(Order::getAmount)
                .sum();
	}

	@Override
	public String trackOrderProgress(String id) {
		
		Optional<Order> byId = orderRepo.findById(id);
		
		return "Your Order Progress is : "+byId.get().getStatus();
	}

	@Override
	public List<Order> allOrdersSummaries() {
		
		return orderRepo.findAll();
	}

	
}
