package com.example.three.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.three.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{

    
}
