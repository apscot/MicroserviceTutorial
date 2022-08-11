package com.example.product.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.microservice.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
