package com.example.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.one.model.Children;

public interface ChildrenRepo extends JpaRepository<Children,Integer>{
     
}
