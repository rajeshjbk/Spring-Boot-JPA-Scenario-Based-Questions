package com.raj.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByOrderStatus(String status);
	List<Order> findByPaymentMode(String mode);
	List<Order> getByTotalAmountGreaterThan(Double amount);
	List<Order> readByOrderDateBetween(LocalDate start, LocalDate end);
	List<Order> findByCustomerNameContaining(String chars);
}
