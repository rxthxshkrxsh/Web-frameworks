package com.example.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.one.model.Product;
import com.example.one.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    public ProductService productService;
    
    @PostMapping("/product")
    public ResponseEntity<Product> getName(@RequestBody Product product) 
    {
        Product p = productService.saveCollege(product);
        if(p!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    @GetMapping("/product/{productId}")
    public Product getMethodName(@PathVariable("productId") int a) {
        return productService.getCollege(a);
    }
    
    @PutMapping("/product/{productId}")
    public Product putMethodName(@PathVariable("productId") int id, @RequestBody Product updateCollege) 
    {
        Product exsistProduct = productService.getCollege(id);
        if(exsistProduct != null)
        {
            exsistProduct.setProductName(updateCollege.getProductName());
            exsistProduct.setProductDescription(updateCollege.getProductDescription());
            productService.saveCollege(exsistProduct);
        }
        else
        {
            return new Product();
        }
        return productService.saveCollege(exsistProduct);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Product> deleteMapping(@PathVariable("productId") int id)
    {
        Product exProduct=productService.getCollege(id);
        if(exProduct != null)
        {
            productService.DeleteStudent(id);
            return ResponseEntity.ok(exProduct);
        }
        else{
        return ResponseEntity.notFound().build();
        }
    }
   
}