package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Person;
import com.example.springapp.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
    
    @Autowired
    public PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> getMeth(@RequestBody Person person)
    {
        Person p = personService.savePerson(person);
        if(p != null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/person/byage/{age}")
    public ResponseEntity<List<Person>> getBy(@PathVariable("age") int a)
    {
        List<Person> p1 = personService.getAges(a);
        if(p1 != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(p1);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
