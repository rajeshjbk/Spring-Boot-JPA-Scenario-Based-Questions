package com.raj.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.raj.entity.Inventory;

import jakarta.transaction.Transactional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	//JPQL SELECT OPERATIONS

	@Query("from Inventory where category= ?1")
	List<Inventory> showItemsByCategory(String category);

	@Query("from Inventory where available=true")
	List<Inventory> showAvailableItems();

	@Query("from Inventory where quantity> ?1")
	List<Inventory> showItemsByQuatityLessThan(int qty);

	@Query("from Inventory where productName like %?1%")
	List<Inventory> searchItemsByName(String name);

	@Query("from Inventory where price>?1and price<?2")
	List<Inventory> fetchItemsByPriceRange(double start, double end);

	//AGGREGATION QUERIES
	@Query("select count(*) from Inventory")
	long countTotalItems();

	@Query("select avg(price) from Inventory")
	double averagePriceOfItems();

	@Query("select max(price) from Inventory")
	Double maxPriceItem();

	//UPDATE OPERATIONS (@Modifying)
	@Query("UPDATE Inventory i SET i.quantity = ?1 WHERE i.category = ?2")
	@Modifying
	@Transactional
	int updateQuantityAfterPurchased(int qty, String category);

	@Query("update Inventory set price= price + price* ?2/100.0 where category= ?1")
	@Modifying
	@Transactional
	int increasePriceOfItem(String category, double hikePercent);

	@Query("update Inventory set available= false where price=0")
	@Modifying
	@Transactional
	int markItemsUnavailable(); 

	@Query("delete from Inventory where available=false")
	@Modifying
	@Transactional
	int deleteUnavailableItems();

	@Query("delete from Inventory where quantity= ?1")
	@Modifying
	@Transactional
	int deleteItemsBelowQty(int qty);

	//================ NATIVE QUERY OPERATIONS ==============================
	@Query(value = "select * from Inventory_Details order by quantity asc", nativeQuery = true)
    List<Inventory> fetchItemsSortedByQuantity();

	@Query(value = "SELECT * FROM Inventory_Details ORDER BY price DESC LIMIT 3", nativeQuery = true)
	List<Inventory> fetchTop3ItemsByPrice();
}
