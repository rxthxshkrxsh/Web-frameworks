package com.example.three.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.three.model.Language;
import com.example.three.repository.LanguageRepo;

@Service
public class LanguageService {
    
    @Autowired
    public LanguageRepo languageRepo;

    public Language saveLanguage(@RequestBody Language language)
    {
        return languageRepo.save(language);
    }
    public List<Language> getAll()
    {
        return languageRepo.findAll();
    }
    public Language getLanguageId(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }
    public boolean deleteLanguage(int a)
    {
        if(languageRepo.existsById(a))
        {
            languageRepo.deleteById(a);
            return true;
        }
        else
        {
            return false;
        }
    }

}