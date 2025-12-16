package com.raj.runners;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.document.Order;
import com.raj.service.IOrderService;

@Component
public class OrderTestRunner implements CommandLineRunner {

	@Autowired
	private IOrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("\n====== Order Tracking System =====");
				System.out.println("1. Add New Order.");
				System.out.println("2. Find the Orders by Status.");
				System.out.println("3. Find the Orders by City.");
				System.out.println("4. Find the Orders Greater than given amount.");
				System.out.println("5. Find the Orders by City and Status.");
				System.out.println("6. Find Orders Sorted by Amount in decending order.");
				System.out.println("7. Find Orders by Latest Date.");
				System.out.println("8. Find Total Orders is Delivered.");
				System.out.println("9. Find Total Orders City-wise.");
				System.out.println("10.Track Your Order Progress.");
				System.out.println("11.Find Total Orders Revenues.");
				System.out.println("12.Show Orders Summeries.");
				System.out.println("13.Exit");
				
				
				System.out.print("Enter Your Choice: ");
				
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Order Customer Name: ");
					String name = sc.nextLine();
					System.out.print("Enter Order City: ");
					String city = sc.nextLine();
					System.out.print("Enter Order Amount: ");
					Double price = Double.parseDouble(sc.nextLine());
					System.out.print("Enter Order Status(PLACED / SHIPPED / DELIVERED): ");
					String status = sc.nextLine();
					
					Order order = new Order(name, city, price, status,new Date());
					
					String saveOrder = orderService.saveOrder(order);
					System.out.println(saveOrder);
					break;
					
				case 2:
					System.out.print("Enter Order Status(PLACED / SHIPPED / DELIVERED): ");
					status = sc.nextLine();
					
					List<Order> byStatus = orderService.findByStatus(status);
					byStatus.forEach(System.out::println);
					break;
					
				case 3:
					System.out.print("Enter Order City: ");
					city = sc.nextLine();
					List<Order> byCity = orderService.findByCity(city);
					byCity.forEach(System.out::println);
					break;
					
				case 4:
					System.out.print("Enter Order Amount: ");
					price = Double.parseDouble(sc.nextLine());
					
					List<Order> byAmountGreaterThan = orderService.findByAmountGreaterThan(price);
					byAmountGreaterThan.forEach(System.out::println);
					break;
					
				case 5:
					System.out.print("Enter Order City: ");
					city = sc.nextLine();
					System.out.print("Enter Order Status(PLACED / SHIPPED / DELIVERED): ");
					status = sc.nextLine();
					
					List<Order> byCityAndStatus = orderService.findByCityAndStatus(city, status);
					byCityAndStatus.forEach(System.out::println);
					break;
					
				case 6:
					List<Order> ordersSortedByAmount = orderService.findOrdersSortedByAmount();
					ordersSortedByAmount.forEach(System.out::println);
					break;
				case 7:
					List<Order> latestOrdersByDate = orderService.findLatestOrdersByDate();
					latestOrdersByDate.forEach(System.out::println);
					break;
				case 8:
					int deliveredOrders = orderService.findByStatus("DELIVERED").size();
					System.out.println("Total Orders is Delivered : "+deliveredOrders);
					break;
				case 9:
					System.out.print("Enter Order City: ");
					city = sc.nextLine();
					int cityWise = orderService.findByCity(city).size();
					System.out.println("Total Orders in City "+city+" : "+cityWise);
					break;
					
				case 10:
					System.out.print("Enter Order ID: ");
					String id = sc.nextLine();
					String trackOrderProgress = orderService.trackOrderProgress(id);
					System.out.println(trackOrderProgress);
					break;
					
				case 11:
					Double totalRevenue = orderService.totalRevenue();
					System.out.println("Total Revenues: "+totalRevenue);
					break;
				case 12:
					List<Order> allOrdersSummaries = orderService.allOrdersSummaries();
					allOrdersSummaries.forEach(System.out::println);
					break;
					
				case 13:
					System.exit(0);
					
				default:
					System.err.println("Invalid Choice..");
				}
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
