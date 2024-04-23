package com.example.one.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.one.model.Person;
import com.example.one.repository.PersonRepo;

@Service
public class PersonService {
    
    @Autowired
    public PersonRepo personRepo;

    public Person savePerson(@RequestBody Person person)
    {
        return personRepo.save(person);
    }

    public List<Person> getAll()
    {
        return personRepo.findAll();
    }

    public List<Person> getByAge(int a)
    {
        return personRepo.findByAge(a);
    }
}
