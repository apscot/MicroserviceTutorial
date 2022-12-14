package com.example.product.microservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.microservice.entity.Products;
import com.example.product.microservice.service.ProductService;


@RestController
@RequestMapping("/prodapi")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("product/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable("id") int id) {
	   Optional<Products> optionalProduct = productService.getProductById(id);
	   if(optionalProduct.isPresent()) {
		   return new ResponseEntity<Products>(optionalProduct.get(),HttpStatus.OK);
	   }
	   else {
		   return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);
	   }
	}
	
	@GetMapping("product")
	public ResponseEntity<List<Products>> getAllProducts() {
	   List<Products> optionalProducts = productService.getAllProducts();
	   if(!optionalProducts.isEmpty()) {
		   return new ResponseEntity<List<Products>>(optionalProducts,HttpStatus.OK);
	   }
	   else {
		   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	   }
	}
	
	@PostMapping("product")
	public ResponseEntity<Products> saveProduct(@RequestBody Products product) {
	   product = productService.saveProduct(product);
	   if(null != product) {
		   return new ResponseEntity<Products>(product,HttpStatus.CREATED);
	   }
	   else {
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	   }
	}
}
