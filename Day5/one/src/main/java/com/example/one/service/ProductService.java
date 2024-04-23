package com.example.one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.one.model.Product;
import com.example.one.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    public ProductRepo collegeRepository;

    public Product saveCollege(@RequestBody Product college)
    {
        return collegeRepository.save(college);
    }
    public Product getCollege(int id)
    {
        return collegeRepository.findById(id).orElse(null);
    }

    public void DeleteStudent(int a)
    {
        collegeRepository.deleteById(a);
    }
}
