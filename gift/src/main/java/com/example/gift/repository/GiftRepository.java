package com.example.gift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gift.model.Giftmodel;


@Repository
public interface GiftRepository extends JpaRepository <Giftmodel,Integer>{
    
}