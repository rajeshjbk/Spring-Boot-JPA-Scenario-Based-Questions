package com.raj.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Product;
import com.raj.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public String addProduct(Product prod) {
		
		Product save = productRepo.save(prod);
		
		return "New Product is added with Product ID: "+save.getProductId();
	}

	@Override
	public String addMultipleProducts(List<Product> list) {
		
		Iterable<Product> saveAll = productRepo.saveAll(list);
		
		List<Integer> list2 = StreamSupport.stream(saveAll.spliterator(), false).map(Product::getProductId).collect(Collectors.toList());
		
		return list2.size()+" no.of New Product is added with Product IDs: "+list2;
	}

	@Override
	public Optional<Product> findById(Integer id) {
		
		Optional<Product> byId = productRepo.findById(id);
		
		if(byId.isPresent()) {
			
			return byId;
		}
		return byId.empty();
	}

	@Override
	public Iterable<Product> showAllProducts() {
		
		Iterable<Product> all = productRepo.findAll();
		return all;
	}

	@Override
	public String updateProductPrice(Integer id, Double newPrice) {
		
		Product product = productRepo.findById(id).get();
		product.setPrice(newPrice);
		
		productRepo.save(product);
		return "Product price is updated.";
	}

	@Override
	public String deleteProductById(Integer id) {
		
		productRepo.deleteById(id);
		
		return "Product is deleted.";
	}

	@Override
	public String deleteAllProducts() {
		
		productRepo.deleteAll();
		
		return "All Products are deleted.";
	}

}
