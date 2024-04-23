package com.example.two.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recipe {
    
    @Id
    private int recipeId;
    private String tite;
    private String ingredients;
    private String instructions;
    private String recipeName;
    
    public int getRecipeId() {
        return recipeId;
    }
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
    public String getTite() {
        return tite;
    }
    public void setTite(String tite) {
        this.tite = tite;
    }
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public Recipe(int recipeId, String tite, String ingredients, String instructions, String recipeName) {
        this.recipeId = recipeId;
        this.tite = tite;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.recipeName = recipeName;
    }

    public Recipe()
    {
        
    }
}
