package com.example.three.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.three.model.Language;
import com.example.three.service.LanguageService;

@RestController
public class LanguageController {
    
    @Autowired
    public LanguageService languageService;

    @PostMapping("/language")
    public ResponseEntity<Language> getLanguage(@RequestBody Language language)
    {
        Language l = languageService.saveLanguage(language);
        if(l != null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(l);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } 
    
    @GetMapping("/language")
    public ResponseEntity<List<Language>> getAllLang()
    {
        List<Language> l1 = languageService.getAll();
        if(l1 != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(l1);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }

    @GetMapping("/language/{languageId}")
    public ResponseEntity<Language> getLanguageId(@PathVariable("languageId") int id)
    {
        Language l2 = languageService.getLanguageId(id);
        if(l2 != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(l2);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/language/{languageId}")
    public ResponseEntity<Language> update(@PathVariable("languageId") int no,@RequestBody Language updateLanguage)
    {
        Language exLanguage = languageService.getLanguageId(no);
        if(exLanguage != null)
        {
            exLanguage.setLanguageName(updateLanguage.getLanguageName());
            exLanguage.setLanguageComplexity(updateLanguage.getLanguageComplexity());
            return ResponseEntity.status(HttpStatus.OK).body(languageService.saveLanguage(exLanguage));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/language/{languageId}")
    public ResponseEntity<Boolean> delete(@PathVariable("languageId") int c)
    {
        boolean l4 = languageService.deleteLanguage(c);
        if(l4)
        {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }
}

