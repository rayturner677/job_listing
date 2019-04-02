package com.joblisting.joblisting.controllers;

import com.joblisting.joblisting.forms.EmployerForm;
import com.joblisting.joblisting.repositories.PostgresEmployerRepository;
import com.joblisting.joblisting.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign-up")

public class SignUp {
    Repository<EmployerForm> employerRepository;

    @Autowired
    public SignUp(PostgresEmployerRepository repository){
        employerRepository = repository;
    }

    @GetMapping
    public String getEmployer(){return "sign-up";}

    @PostMapping
    public String postEmployer(EmployerForm employer){
        if(employer.isValid()){
            employerRepository.save(employer);
            return "redirect:/home";
        } else {
            return "sign-up";
        }
    }
}
