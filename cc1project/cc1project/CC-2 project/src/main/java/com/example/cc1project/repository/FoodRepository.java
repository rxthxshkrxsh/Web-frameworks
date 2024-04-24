package com.example.cc1project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cc1project.model.Food;
import java.util.List;


@Repository
public interface FoodRepository extends JpaRepository<Food,Integer>{
    @Query("select f.foodName from Food f where foodPrice= ?1")
    List<String> findByFoodPrice(String a);
} 