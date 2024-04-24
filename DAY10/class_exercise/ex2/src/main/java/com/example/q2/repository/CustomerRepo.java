package com.example.q2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.q2.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{
    @Query("select c from Customer c where c.city=?1")
    List<Customer> findByCity(String city);
} 
