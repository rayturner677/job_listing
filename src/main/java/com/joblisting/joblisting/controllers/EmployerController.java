package com.joblisting.joblisting.controllers;

import com.joblisting.joblisting.forms.EmployerForm;
import com.joblisting.joblisting.repositories.PostgresEmployerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")

public class EmployerController {
    @GetMapping
    public String getEmployer(){return "employer";}

    @PostMapping
    public String postEmployer(EmployerForm employer, PostgresEmployerRepository repository){
        if(employer.isValid()){
            repository.save(employer);
        } else {
            System.out.println("Something went wrong");
        }
        return "landing";
    }
}
