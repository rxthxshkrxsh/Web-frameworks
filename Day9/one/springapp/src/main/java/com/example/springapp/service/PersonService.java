package com.example.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.springapp.model.Person;
import com.example.springapp.repository.PersonRepo;

@Service
public class PersonService {
    public PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person savePerson(@RequestBody Person person) {
        return personRepo.save(person);
    }

    public List<Person> getAges(int age) {
        return personRepo.findByAge(age);
    }
}
