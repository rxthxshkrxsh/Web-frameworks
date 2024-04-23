package com.example.two.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.two.model.Student;
import com.example.two.repository.StudentRepo;

@Service
public class StudentService {
    
    @Autowired
    public StudentRepo childrenRepo;

    public Student saveChildren(@RequestBody Student children)
    {
        return childrenRepo.save(children);
    }
    public List<Student> sortList(int a,int b,String c)
    {
        Page <Student> pg = childrenRepo.findAll(PageRequest.of(a, b, Sort.by(c)));
        return pg.getContent();
    }
    public List<Student> pagChildrens(int no,int sz)
    {
        Page <Student> pg1 = childrenRepo.findAll(PageRequest.of(no, sz));
        return pg1.getContent();
    }
}