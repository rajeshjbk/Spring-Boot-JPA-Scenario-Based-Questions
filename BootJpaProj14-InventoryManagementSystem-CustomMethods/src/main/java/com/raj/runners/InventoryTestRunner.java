package com.raj.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.Inventory;
import com.raj.repository.InventoryRepository;
@Component
public class InventoryTestRunner implements CommandLineRunner {

	@Autowired
	private InventoryRepository inventoryRepo;
		
	@Override
	public void run(String... args) throws Exception {
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				
				System.out.println("\n============== Inventory Management System ==============");
				System.out.println("1. Add New Item.");
				System.out.println("2. Fetch items by category.");
				System.out.println("3. Fetch available items");
				System.out.println("4. Fetch items with quantity less than given value.");
				System.out.println("5. Search items by product name (LIKE)");
				System.out.println("6. Fetch items within a price range.");
				System.out.println("7. Count total items");
				System.out.println("8. Get average price of items");
				System.out.println("9. Get maximum priced item");
				System.out.println("10.Update quantity after purchase.");
				System.out.println("11.Increase price by percentage for a category");
				System.out.println("12.Mark items unavailable if quantity is zero.");
				System.out.println("13.Delete unavailable items.");
				System.out.println("14.Delete items below a certain quantity.");
				System.out.println("15.Fetch inventory sorted by quantity");
				System.out.println("16.Fetch top 3 most expensive items");
				System.out.println("17.Exit.");
				
				System.out.print("\nEnter Your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter Product Name: ");
					String name = sc.nextLine();
					
					System.out.print("Enter Product Category: ");
					String category = sc.nextLine();
					
					System.out.print("Enter Product Quantity: ");
					Integer qty = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Product Price: ");
					double price = Double.parseDouble(sc.nextLine());
					
					System.out.print("Enter Product Available(true/false): ");
					boolean avail = Boolean.parseBoolean(sc.nextLine());
					
					Inventory inventory = new Inventory(name, category, qty, price, avail);
					
					Integer id = inventoryRepo.save(inventory).getId();
				    
					System.out.println("New Item is added with ID: "+id);
					break;
					
				case 2:
					System.out.print("Enter Product Category: ");
					category = sc.nextLine();
					inventoryRepo.showItemsByCategory(category).forEach(System.out::println);
					break;
					
				case 3:				
					inventoryRepo.showAvailableItems().forEach(System.out::println);
					break;
					
				case 4:
					System.out.print("Enter Product Quantity: ");
					qty = Integer.parseInt(sc.nextLine());
					inventoryRepo.showItemsByQuatityLessThan(qty).forEach(System.out::println);
					break;
					
				case 5:
					System.out.print("Enter Product Name: ");
					name = sc.nextLine();
					
					inventoryRepo.searchItemsByName(name).forEach(System.out::println);
					break;
					
				case 6:
					System.out.print("Enter Product Min Price: ");
					double min = Double.parseDouble(sc.nextLine());
					System.out.print("Enter Product Max Price: ");
					double max = Double.parseDouble(sc.nextLine());
					
					inventoryRepo.fetchItemsByPriceRange(min, max).forEach(System.out::println);
					break;
					
				case 7:
					long countTotalItems = inventoryRepo.countTotalItems();
					System.out.println("Total Items: "+countTotalItems);
					break;
				case 8:
					double averagePriceOfItems = inventoryRepo.averagePriceOfItems();
					System.out.println("Average Price Of Items: "+averagePriceOfItems);
					break;
				case 9:
					Double maxPriceItem = inventoryRepo.maxPriceItem();
					System.out.println("Max Price Item: "+maxPriceItem);
					break;
				case 10:
					System.out.print("Enter Product new Quantity: ");
					qty = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Product Category: ");
					category = sc.nextLine();
					
					int updateQuantityAfterPurchased = inventoryRepo.updateQuantityAfterPurchased(qty, category);
					System.out.println(updateQuantityAfterPurchased+" Items are updated of Category: "+category);
					break;
					
				case 11:
					System.out.print("Enter Product Category: ");
					category = sc.nextLine();
					
					System.out.print("Enter Hike Percent: ");
					double hikePercent = Double.parseDouble(sc.nextLine());
					
					int increasePriceOfItem = inventoryRepo.increasePriceOfItem(category, hikePercent);
					System.out.println(increasePriceOfItem+" no.of Items are updated of Category: "+category);
					break;
					
				case 12:
					int markItemsUnavailable = inventoryRepo.markItemsUnavailable();
					System.out.println(markItemsUnavailable+" no.of Items are Unavailable.");
					break;
				case 13:
					int deleteUnavailableItems = inventoryRepo.deleteUnavailableItems();
					System.out.println(deleteUnavailableItems+" no.of Unavailable Items are Deleted.");
					break;
					
				case 14:
					System.out.print("Enter Product Quantity: ");
					qty = Integer.parseInt(sc.nextLine());
					
					int deleteItemsBelowQty = inventoryRepo.deleteItemsBelowQty(qty);
					
					System.out.println("Quantity < "+qty+ " -> "+deleteItemsBelowQty+ " no.of Items are Deleted.");
					break;
				case 15:
					inventoryRepo.fetchItemsSortedByQuantity().forEach(System.out::println);
					break;
				case 16:
					inventoryRepo.fetchTop3ItemsByPrice().forEach(System.out::println);
					break;
				case 17:
				   System.exit(0);
				}
				
			}
		}catch (Exception e) {
		
			e.printStackTrace();
		}

	}

}
