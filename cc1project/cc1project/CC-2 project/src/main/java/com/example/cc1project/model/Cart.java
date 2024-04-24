package com.example.cc1project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    @OneToOne (mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Payment payment;

    @OneToOne
    @JsonBackReference
    private Signup signup;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> food;
}