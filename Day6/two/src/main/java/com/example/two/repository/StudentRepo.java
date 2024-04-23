package com.example.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.two.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

    
}