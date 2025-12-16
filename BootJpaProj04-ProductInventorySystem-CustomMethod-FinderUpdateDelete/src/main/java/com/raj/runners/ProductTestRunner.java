package com.raj.runners;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.document.Product;
import com.raj.service.IProductService;

@Component
public class ProductTestRunner implements CommandLineRunner {

	@Autowired
	private IProductService productService;

	@Override
	public void run(String... args) throws Exception {

		try(Scanner sc = new Scanner(System.in)){

			while(true) {

				System.out.println("\n====== Product Management System ======");
				System.out.println("1. Add new Product. ");
				System.out.println("2. Find Products by Category.");
				System.out.println("3. Find Products by Brand.");
				System.out.println("4. Find Products By Stock Greater Than.");
				System.out.println("5. Find Products Available.");
				System.out.println("6. Update Product Stock By Pid.");
				System.out.println("7. Update Product Price By Brand.");
				System.out.println("8. Exit. ");

				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {

				case 1:
					System.out.print("Enter Product Name: ");
					String name = sc.nextLine();
					System.out.print("Enter Product Category: ");
					String category = sc.nextLine();
					System.out.print("Enter Product Brand: ");
					String brand = sc.nextLine();
					System.out.print("Enter Product Price: ");
					Double price = Double.parseDouble(sc.nextLine());
					System.out.print("Enter Product Stock: ");
					Integer stock = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Product Available(true/false): ");
					Boolean status = Boolean.parseBoolean(sc.nextLine());

					Product prod = new Product(name, category, brand, price, stock, status);
					String saveProduct = productService.saveProduct(prod);
					System.out.println(saveProduct);
					break;
				case 2:
					System.out.print("Enter Product Category: ");
					category = sc.nextLine();
					List<Product> byCategory = productService.findByCategory(category);
					byCategory.forEach(System.out::println);
					break;
				case 3:
					System.out.print("Enter Product Brand: ");
					brand = sc.nextLine();
					List<Product> byBrand = productService.findByBrand(brand);
					System.out.println(byBrand);
					break;
				case 4:
					System.out.print("Enter Product Stock: ");
					stock = Integer.parseInt(sc.nextLine());
					List<Product> byStock = productService.findByStockGreaterThan(stock);	
					byStock.forEach(System.out::println);
					break;
				case 5:
					System.out.print("Enter Product Available(true/false): ");
					status = Boolean.parseBoolean(sc.nextLine());
					List<Product> byAvailable = productService.findByAvailable(status);
					byAvailable.forEach(System.out::println);
					break;
				case 6:
					System.out.print("Enter Product ID: ");
					String id = sc.nextLine();
					System.out.print("Enter Product New Stock: ");
					stock = Integer.parseInt(sc.nextLine());

					String updateByPid = productService.updateStockByPid(id,stock);
					System.out.println(updateByPid);
					break;
				case 7:
					System.out.print("Enter Product Brand: ");
					brand = sc.nextLine();
					System.out.print("Enter Product Price: ");
					Double newPrice = Double.parseDouble(sc.nextLine());
					String updatePriceByBrand = productService.updatePriceByBrand(brand,newPrice);
					System.out.println(updatePriceByBrand);
					break;
				case 8:
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
