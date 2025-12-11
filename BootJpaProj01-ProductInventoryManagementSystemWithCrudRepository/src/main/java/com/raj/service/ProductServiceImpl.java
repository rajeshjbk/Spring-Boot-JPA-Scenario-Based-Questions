package com.raj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Product;
import com.raj.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productDetailsCrudRepo;
	
	@Override
	public String saveProduct(Product product) {
		
		Product prod = productDetailsCrudRepo.save(product);
		
		return "Product Details are saved with ProductId: "+prod.getProductId();
	}

	@Override
	public Optional<Product> getProductById(Integer id) {
		
		Optional<Product> byId = productDetailsCrudRepo.findById(id);
		return byId;
	}

	@Override
	public List<Product> getAllProducts() {
		
		Iterable<Product> all = productDetailsCrudRepo.findAll();
		
		return (List<Product>) all;
	}

}
