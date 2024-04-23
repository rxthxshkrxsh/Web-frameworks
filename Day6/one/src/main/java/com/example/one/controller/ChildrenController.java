package com.example.one.controller;

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

import com.example.one.model.Children;
import com.example.one.service.ChildrenService;

@RestController
@RequestMapping("/api")
public class ChildrenController {
    
    @Autowired
    public ChildrenService childrenService;

    @PostMapping("/children")
    public ResponseEntity<Children> getChildren(@RequestBody Children children)
    {
        Children c = childrenService.saveChildren(children);
        if(c != null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(c);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
    @GetMapping("/children/sortBy/{field}")
    public ResponseEntity<List<Children>> gSort(@PathVariable("field") String a)
    {
        List<Children> l = childrenService.getAll(a);
        if(l != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(l);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/children/{offset}/{pagesize}")
    public ResponseEntity<List<Children>>  divide(@PathVariable("offset") int pn,@PathVariable("pagesize") int sz)
    {
        List<Children> l1 = childrenService.pagChildrens(pn, sz);
        if(l1 !=  null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(l1);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Children>>  divides(@PathVariable("offset") int pn1,@PathVariable("pagesize") int sz1,@PathVariable("field") String so)
    {
        List<Children> l2 = childrenService.sortList(pn1, sz1, so);
        if(l2 !=  null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(l2);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
