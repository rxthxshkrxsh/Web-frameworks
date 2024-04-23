package com.example.two.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.two.model.Recipe;



public interface RecipeRepo extends JpaRepository<Recipe,Integer>{

    @Query("select e from Recipe e where e.recipeName = ?1")
    List<Recipe> findByRecipeName(String a);
}

