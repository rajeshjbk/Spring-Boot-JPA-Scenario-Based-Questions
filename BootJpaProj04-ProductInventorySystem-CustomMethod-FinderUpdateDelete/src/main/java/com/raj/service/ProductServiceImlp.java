package com.raj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.document.Product;
import com.raj.repository.IProductRepository;

@Service
public class ProductServiceImlp implements IProductService {

	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public String saveProduct(Product prod) {
		
		Product save = productRepo.save(prod);
		return "New Product is added with ID: "+save.getPid();
	}

	@Override
	public List<Product> findByCategory(String category) {
		
		List<Product> byCategory = productRepo.findByCategory(category);
		return byCategory;
	}

	@Override
	public List<Product> findByBrand(String brand) {
		
		List<Product> byBrand = productRepo.findByBrand(brand);
		return byBrand;
	}

	@Override
	public List<Product> findByStockGreaterThan(Integer stock) {
		
		List<Product> byStockGreaterThan = productRepo.findByStockGreaterThan(stock);
		return byStockGreaterThan;
	}

	@Override
	public List<Product> findByAvailable(Boolean available) {
		
		List<Product> byAvailable = productRepo.findByAvailable(available);
		return byAvailable;
	}

	@Override
	public String updateStockByPid(String id, Integer stock) {
		
		long updateByPid = productRepo.updateStockByPid(id, stock);
		
		return "Product is Updated new Stock : "+stock;
	}

	@Override
	public String updatePriceByBrand(String brand, Double price) {
		
		long updatePriceByBrand = productRepo.updatePriceByBrand(brand, price);
		return "Price is updated successfully of brand: "+brand;
	}

	@Override
	public String deleteByCategory(String category) {
		
		productRepo.deleteByCategory(category);
		
		return "Product is deleted where category: "+category;
	}

}
