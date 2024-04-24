package com.example.q1.repository;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.q1.model.Door;

@Repository
public interface DoorRepo extends JpaRepository<Door,Integer> {
   


    @Query("select d from Door d where d.color=?1")
    List<Door>findByColor(String color);

    @Query("select d from Door d where d.doorType=?1")
    List<Door>findByDoorType(String doorType);

    @Query("select d from Door d where d.doorId=?1")
    List<Door>findByDoorId(int doorId);

   

   

    
}
