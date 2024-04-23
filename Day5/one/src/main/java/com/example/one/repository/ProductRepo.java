package com.example.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.one.model.Product;

public interface ProductRepo extends JpaRepository <Product,Integer>{

    
}
