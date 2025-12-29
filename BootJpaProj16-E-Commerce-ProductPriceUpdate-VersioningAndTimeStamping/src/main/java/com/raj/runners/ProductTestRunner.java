package com.raj.runners;

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

			while(true) {

				System.out.println("========== Product management System ===========");
				System.out.println("1. Add New Product.");
				System.out.println("2. Fetch Product by ID.");
				System.out.println("3. Show All Product.");
				System.out.println("4. Update Product Price.");
				System.out.println("5. Delete Product by ID.");
				System.out.println("6. Exit.");

				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {

				case 1:
					System.out.print("Enter Product Name: ");
					String name = sc.nextLine();
					
					System.out.print("Enter Product Price: ");
					Double price = Double.parseDouble(sc.nextLine());
					
					Product product = new Product(name, price);
					
					String product2 = productService.addProduct(product);
					
					System.out.println(product2);
					break;
					
				case 2:
					System.out.print("Enter Product ID: ");
					int id = Integer.parseInt(sc.nextLine());
					
					Optional<Product> fetchProductById = productService.fetchProductById(id);
					if(fetchProductById.isPresent())
						System.out.println(fetchProductById.get());
					break;
					
				case 3:
					productService.showAllProducts().forEach(System.out::println);
					break;
					
				case 4:
					System.out.print("Enter Product ID: ");
				    id = Integer.parseInt(sc.nextLine());
				    
				    System.out.print("Enter Product New Price: ");
					price = Double.parseDouble(sc.nextLine());
					
					String updateProductPrice = productService.updateProductPrice(id, price);
					System.out.println(updateProductPrice);
					break;
				case 5:
					System.out.print("Enter Product ID: ");
				    id = Integer.parseInt(sc.nextLine());
				    
				    String deleteProduct = productService.deleteProduct(id);
					System.out.println(deleteProduct);
				    break;
				case 6:
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
