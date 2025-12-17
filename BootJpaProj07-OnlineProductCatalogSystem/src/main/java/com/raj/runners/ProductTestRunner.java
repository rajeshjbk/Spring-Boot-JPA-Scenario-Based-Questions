package com.raj.runners;

import java.util.ArrayList;
import java.util.List;
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
				System.out.println("\n======= Product Management System =======");
				System.out.println("1. Add New Product.");
				System.out.println("2. Add Multiple Products.");
				System.out.println("3. Find Product By Product ID.");
				System.out.println("4. View All Products.");
				System.out.println("5. Update Product Price By ID.");
				System.out.println("6. Delete Product By ID.");
				System.out.println("7. Delete All Products");
				System.out.println("8. Exit.");
				System.out.print("Enter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {

				case 1:
					System.out.print("Enter Product Name: ");
					String name = sc.nextLine();
					System.out.print("Enter Product Brand: ");
					String brand = sc.nextLine();
					System.out.print("Enter Product Price: ");
					Double price = Double.parseDouble(sc.nextLine());
					System.out.print("Enter Product Stock: ");
					Integer stock = Integer.parseInt(sc.nextLine());

					Product product = new Product(name, brand, price, stock);

					String addProduct = productService.addProduct(product);
					System.out.println(addProduct);
					break;
					
				case 2:
					System.out.print("How many Products You want to add: ");
					int noOfProducts = Integer.parseInt(sc.nextLine());

					List<Product> list = new ArrayList<>();

					for(int i=1; i<=noOfProducts; i++) {

						System.out.println("Enter "+i+" Product Details.");
						System.out.print("Enter Product Name: ");
						name = sc.nextLine();
						System.out.print("Enter Product Brand: ");
						brand = sc.nextLine();
						System.out.print("Enter Product Price: ");
						price = Double.parseDouble(sc.nextLine());
						System.out.print("Enter Product Stock: ");
						stock = Integer.parseInt(sc.nextLine());

						product = new Product(name, brand, price, stock);
						list.add(product);
					}
					String multipleProducts = productService.addMultipleProducts(list);
					System.out.println(multipleProducts);
					break;
					
				case 3:
					System.out.print("Enter Product ID: ");
					Integer pId = Integer.parseInt(sc.nextLine());
					
					Product product2 = productService.findById(pId).get();
					System.out.println(product2);
					break;
				case 4:
					Iterable<Product> showAllProducts = productService.showAllProducts();
					showAllProducts.forEach(System.out::println);
					break;

				case 5:
					System.out.print("Enter Product ID: ");
					pId = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Product New Price: ");
					Double newPrice = Double.parseDouble(sc.nextLine());
					String updateProductPrice = productService.updateProductPrice(pId, newPrice);
					System.out.println(updateProductPrice);
					break;
					
				case 6:
					System.out.print("Enter Product ID: ");
					pId = Integer.parseInt(sc.nextLine());
					String deleteProductById = productService.deleteProductById(pId);
					System.out.println(deleteProductById);
					break;
					
				case 7:
					String deleteAllProducts = productService.deleteAllProducts();
					System.out.println(deleteAllProducts);
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
