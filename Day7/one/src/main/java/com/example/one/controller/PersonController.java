package com.example.one.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.one.model.Person;
import com.example.one.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
    
    @Autowired
    public PersonService personService;
    
    @PostMapping("/person")
    public ResponseEntity<Person> getSave(@RequestBody Person person)
    {
        Person p = personService.savePerson(person);
        if(p != null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAlls()
    {
        List<Person> p = personService.getAll();
        if(p != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(p);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
 
    @GetMapping("/person/byAge")
    public ResponseEntity<List<Person>> getAges(@RequestParam int age)
    {
        List<Person> p = personService.getByAge(age);
        if(p != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(p);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


}

