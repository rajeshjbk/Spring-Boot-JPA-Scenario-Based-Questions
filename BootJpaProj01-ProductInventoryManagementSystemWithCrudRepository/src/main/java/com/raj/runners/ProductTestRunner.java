package com.raj.runners;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Product;
import com.raj.service.IProductService;

@Component
public class ProductTestRunner implements CommandLineRunner {

	@Autowired
	private IProductService productService;

	@Override
	public void run(String... args) throws Exception {

		try(Scanner sc = new Scanner(System.in)){

			System.out.println("===== PRODUCT INVENTORY SYSTEM =====\n");
			while(true) {

				System.out.println("1. Add Product");
				System.out.println("2. View Product");
				System.out.println("3. View All Products");

				System.out.print("\nEnter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {

				case 1:
					System.out.print("Enter Product Name: ");
					String name=sc.nextLine();

					System.out.print("Enter Product Category: ");
					String category = sc.nextLine();

					System.out.print("Enter Product Price: ");
					double price = Double.parseDouble(sc.nextLine());

					System.out.print("Enter Product Stock: ");
					int stock = Integer.parseInt(sc.nextLine());

					Product prod = new Product(name, category, price, stock);

					String saveProduct = productService.saveProduct(prod);

					System.out.println(saveProduct);
					break;

				case 2:
					System.out.println("Enter PID, Which you want to get: ");
					Integer id = Integer.parseInt(sc.nextLine());

					Optional<Product> productById = productService.getProductById(id);
					System.out.println(productById.get());
					break;

				case 3:
					List<Product> allProducts = productService.getAllProducts();

					System.out.println("All Products are: ");

					allProducts.forEach(System.out::println);

					break;

				default:
					System.err.println("Invalid type...");
				}
				System.out.println();
			}
		}catch(Exception e) {

			e.printStackTrace();
		}
	}

}
