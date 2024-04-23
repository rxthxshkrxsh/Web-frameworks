package com.example.two.controller;

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

import com.example.two.model.Employee;
import com.example.two.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    public EmployeeService productService;
    
    @PostMapping("/product")
    public ResponseEntity<Employee> getName(@RequestBody Employee product) 
    {
        Employee p = productService.saveCollege(product);
        if(p!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    @GetMapping("/product/{productId}")
    public Employee getMethodName(@PathVariable("productId") int a) {
        return productService.getCollege(a);
    }
    
    @PutMapping("/product/{productId}")
    public ResponseEntity<Employee> putMethodName(@PathVariable("productId") int id, @RequestBody Employee updateCollege) 
    {
        Employee exsistProduct = productService.getCollege(id);
        if(exsistProduct != null)
        {
            exsistProduct.setDepartment(updateCollege.getDepartment());
            exsistProduct.setEmployeeEmail(updateCollege.getEmployeeEmail());
            exsistProduct.setEmployeeName(updateCollege.getEmployeeName());
            exsistProduct.setSalary(updateCollege.getSalary());
            return ResponseEntity.status(HttpStatus.OK).body(productService.saveCollege(exsistProduct));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Employee> deleteMapping(@PathVariable("productId") int id)
    {
        Employee exProduct=productService.getCollege(id);
        if(exProduct != null)
        {
            productService.DeleteStudent(id);
            return ResponseEntity.ok(exProduct);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
   
}