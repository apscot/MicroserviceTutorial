package com.example.product.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.microservice.entity.Products;
import com.example.product.microservice.repository.ProductsRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductsRepository productsRepository;

	public Optional<Products> getProductById(int id) {
		// TODO Auto-generated method stub
		return productsRepository.findById(id);
	}

	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

	public Products saveProduct(Products product) {
		// TODO Auto-generated method stub
		return productsRepository.save(product);
	}

}
