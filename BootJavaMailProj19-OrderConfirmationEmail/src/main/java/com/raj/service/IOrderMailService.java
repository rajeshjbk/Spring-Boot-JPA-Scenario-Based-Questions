package com.raj.service;

import com.raj.model.Order;

public interface IOrderMailService {

	void sendOrderConfirmation(Order order);
}
