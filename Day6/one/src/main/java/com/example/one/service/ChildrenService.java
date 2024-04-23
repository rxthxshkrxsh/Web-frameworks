package com.example.one.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.one.model.Children;
import com.example.one.repository.ChildrenRepo;

@Service
public class ChildrenService {
    
    @Autowired
    public ChildrenRepo childrenRepo;

    public Children saveChildren(@RequestBody Children children)
    {
        return childrenRepo.save(children);
    }
    public List<Children> getAll(String s)
    {
        return childrenRepo.findAll(Sort.by(s));
    }
    public List<Children> sortList(int a,int b,String c)
    {
        Page <Children> pg = childrenRepo.findAll(PageRequest.of(a, b, Sort.by(c)));
        return pg.getContent();
    }
    public List<Children> pagChildrens(int no,int sz)
    {
        Page <Children> pg1 = childrenRepo.findAll(PageRequest.of(no, sz));
        return pg1.getContent();
    }
}
