package com.raj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.raj.model.Order;
import com.raj.model.OrderMailDTO;

@Service
public class OrderMailServiceImpl implements IOrderMailService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendOrderConfirmation(Order order) {

		System.out.println("Preparing order confirmation email...");

		String message = """
				Dear Customer,

				Your order has been placed successfully.

				Product: %s
				Quantity: %d
				Total Amount: ₹%.2f

				Thank you for shopping with us!
				""".formatted(
						order.getProductName(),
						order.getQuantity(),
						order.getTotalAmount()
						);

		OrderMailDTO dto = new OrderMailDTO(
				order.getCustomerEmail(),
				"Order Confirmation - " + order.getOrderId(),
				message
				);

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(dto.getTo());
		mailMessage.setSubject(dto.getSubject());
		mailMessage.setText(dto.getMessage());

		System.out.println("Sending email to: " + dto.getTo());
		mailSender.send(mailMessage);

		System.out.println("Order confirmation email sent!");
	}
}
