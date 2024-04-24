package com.example.cc1project.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.cc1project.model.Signup;
import com.example.cc1project.service.SignupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/food")
public class SignupController {
    
    @Autowired
    public SignupService signupService;

    @PostMapping("/signup/post")
    public Signup getName(@RequestBody Signup signup) 
    {
        return signupService.saveSignup(signup);
    }
    
    @GetMapping("/sign/post/{signupid}")
    public Signup getId(@PathVariable("signupid") int a) 
    {
        return signupService.getSignupId(a);
    }
    
    @GetMapping("/sign/posts")
    public List<Signup> getAll() 
    {
        return signupService.getAllList();
    }
    
    @PutMapping("/sign/put/{signUpid}")
    public String updateTable(@PathVariable("signUpid") int id, @RequestBody Signup updateSignup)
    {
         Signup exSignup=signupService.getSignupId(id);    
         if(exSignup != null)
         {
            exSignup.setUserName(updateSignup.getUserName());
            exSignup.setMobileNo(updateSignup.getMobileNo());
            exSignup.setPassWord(updateSignup.getPassWord());
            exSignup.setEmail(updateSignup.getPassWord());
            signupService.saveSignup(exSignup);
         }
         else
         {
            return "No Data's Found To Update";
         }
         return "Data's Updated";
    }

    @DeleteMapping("/sign/del/{signid}")
    public String deleteData(@PathVariable("signid") int id)
    {
        Signup exsistSignup = signupService.getSignupId(id);
        if(exsistSignup != null)
        {
            signupService.deleteData(id);
        }
        else
        {
            return "No Data found to be Deleted";
        }
        return "Data Found and Deleted";
    }
}
