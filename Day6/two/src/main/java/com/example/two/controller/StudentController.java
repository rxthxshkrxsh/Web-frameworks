package com.example.two.controller;

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

import com.example.two.model.Student;
import com.example.two.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
    
    @Autowired
    public StudentService childrenService;

    @PostMapping("/student")
    public ResponseEntity<Student> getChildren(@RequestBody Student children)
    {
        Student c = childrenService.saveChildren(children);
        if(c != null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(c);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>>  divide(@RequestParam int pn,@RequestParam int sz)
    {
        List<Student> l1 = childrenService.pagChildrens(pn, sz);
        if(l1 !=  null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(l1);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/student/sort")
    public ResponseEntity<List<Student>>  divides(@RequestParam int pn1,@RequestParam int sz1,@RequestParam String so)
    {
        List<Student> l2 = childrenService.sortList(pn1, sz1, so);
        if(l2 !=  null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(l2);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
