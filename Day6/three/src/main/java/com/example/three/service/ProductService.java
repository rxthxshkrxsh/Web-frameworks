package com.example.three.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.three.model.Product;
import com.example.three.repository.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    public ProductRepo childrenRepo;

    public Product saveChildren(@RequestBody Product children)
    {
        return childrenRepo.save(children);
    }
    public Product getAll(int id)
    {
        return childrenRepo.findById(id).orElse(null);
    }
    public List<Product> sortList(int a,int b,String c)
    {
        Page <Product> pg = childrenRepo.findAll(PageRequest.of(a, b, Sort.by(c)));
        return pg.getContent();
    }
    public List<Product> pagChildrens(int no,int sz)
    {
        Page <Product> pg1 = childrenRepo.findAll(PageRequest.of(no, sz));
        return pg1.getContent();
    }
     
}
