package com.raj.runners;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Order;
import com.raj.repository.IOrderRepository;

@Component
public class OrderTestRunner implements CommandLineRunner {

	@Autowired
	private IOrderRepository orderRepo;

  	@Override
	public void run(String... args) throws Exception {
		
        try(Scanner sc = new Scanner(System.in)){
        	
        	while(true) {
        		System.out.println("\n====== Order Management System ======");
        		System.out.println("1. Add New Order.");
        		System.out.println("2. Find orders by order status.");
        		System.out.println("3. Find orders by payment mode.");
        		System.out.println("4. Find orders with total amount greater than a value.");
        		System.out.println("5. Find orders between two dates.");
        		System.out.println("6. Find orders by customer name containing a keyword.");
        		System.out.println("7. Exit.");
        		
        		System.out.print("Enter Your Choice: ");
        		int choice = Integer.parseInt(sc.nextLine());
        		
        		switch(choice) {
        		case 1:
        			System.out.print("Enter Customer Name: ");
        			String customerName = sc.nextLine();
        	
        			System.out.print("Enter Order Status (PLACED / SHIPPED / DELIVERED): ");
        			String orderStatus = sc.nextLine();
        			
        			System.out.print("Enter Payment Mode (COD / UPI / CARD): ");
        			String paymentMode = sc.nextLine();
        			
        			System.out.print("Enter Total Amount: ");
        			Double amt = Double.parseDouble(sc.nextLine());
        			
        			System.out.print("Enter Order Date: ");
        			LocalDate date = LocalDate.parse(sc.nextLine());
        			
        			Order order = new Order(customerName, orderStatus, paymentMode, amt, date);
        			Order save = orderRepo.save(order);
        			System.out.println("New Order is Added with Order ID: "+save.getOrderId());
        			break;
        		case 2:
        			System.out.print("Enter Order Status: ");
        			String status = sc.nextLine();
        			
        			List<Order> byOrderStatus = orderRepo.findByOrderStatus(status);
        			byOrderStatus.forEach(System.out::println);
        			break;
        		case 3:
        			System.out.print("Enter Order Payment Mode: ");
        			paymentMode = sc.nextLine();
        			orderRepo.findByPaymentMode(paymentMode).forEach(System.out::println);
        			break;
        			
        		case 4:
        			System.out.println("Enter the Total Amount: ");
        		    amt = Double.parseDouble(sc.nextLine());
        		    orderRepo.getByTotalAmountGreaterThan(amt).forEach(System.out::println);
        			break;
        			
        		case 5:
        			System.out.print("Enter Start Date: ");
        			String d1 = sc.nextLine();
        			LocalDate start = LocalDate.parse(d1);
        			
        			System.out.print("Enter End Date: ");
        			String d2 = sc.nextLine();
        			LocalDate end = LocalDate.parse(d2);

        			orderRepo.readByOrderDateBetween(start, end).forEach(System.out::println);
        			break;
        			
        		case 6:
        			System.out.print("Enter a pattern: ");
        			String chars = sc.nextLine();
        			
        			orderRepo.findByCustomerNameContaining(chars).forEach(System.out::println);
        			break;
        		case 7:
        			System.exit(0);
        		default:
        			System.err.println("Invalid Choice...");
        		}
        	}
        }catch (Exception e) {
			
        	e.printStackTrace();
		}
	}

}
