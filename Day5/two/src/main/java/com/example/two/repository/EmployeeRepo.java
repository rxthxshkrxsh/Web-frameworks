package com.example.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.two.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

    
}
