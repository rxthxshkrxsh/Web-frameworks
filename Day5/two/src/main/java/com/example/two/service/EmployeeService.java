package com.example.two.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.two.model.Employee;
import com.example.two.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepo collegeRepository;

    public Employee saveCollege(@RequestBody Employee college)
    {
        return collegeRepository.save(college);
    }
    public Employee getCollege(int id)
    {
        return collegeRepository.findById(id).orElse(null);
    }

    public void DeleteStudent(int a)
    {
        collegeRepository.deleteById(a);
    }
}