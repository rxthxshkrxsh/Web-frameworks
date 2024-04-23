package com.example.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.one.model.Person;

public interface PersonRepo extends JpaRepository<Person,Integer>{
    
    List<Person> findByAge(int a);
}
