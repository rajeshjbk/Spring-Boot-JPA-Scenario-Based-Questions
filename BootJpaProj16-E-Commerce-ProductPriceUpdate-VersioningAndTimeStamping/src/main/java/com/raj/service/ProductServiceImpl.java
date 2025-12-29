package com.raj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Product;
import com.raj.repository.IProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepo;

	@Override
	public String addProduct(Product product) {

		Product save = productRepo.save(product);
		return "Product is Added with ID: "+save.getProductId();
	}

	@Override
	public Optional<Product> fetchProductById(int id) {

		Optional<Product> byId = productRepo.findById(id);

		if(byId.isPresent())
			return byId;

		return Optional.empty();
	}

	@Override
	public List<Product> showAllProducts() {

		List<Product> all = productRepo.findAll();
		return all;
	}

	@Override
	public String updateProductPrice(int id, double price) {

		Optional<Product> byId = productRepo.findById(id);

		if(byId.isPresent()) {
			
			Product product = byId.get();
			product.setPrice(price);
			
			return "Product is updated with ID: "+id;
		}

		return "Product id is invalid.";
	}

	@Override
	public String deleteProduct(int id) {

		Optional<Product> byId = productRepo.findById(id);

		if(byId.isPresent()) {
			productRepo.deleteById(id);
			return "Product is deleted with ID: "+id;
		}

		return "Product id is invalid.";
	}

}
