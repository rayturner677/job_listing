package com.joblisting.joblisting.controllers;

import com.joblisting.joblisting.forms.EmployerForm;
import com.joblisting.joblisting.repositories.PostgresEmployerRepository;
import com.joblisting.joblisting.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")

public class LandingController {
    Repository<EmployerForm> repository;

    @Autowired
    public LandingController(PostgresEmployerRepository employerRepository){
        repository = employerRepository;
    }
    @GetMapping
    public String getPage(Model model){
        model.addAttribute("employers", repository.findAll());
        return "landing";
    }

    @PostMapping
    public String postPage(){
        return "landing";
    }

    @GetMapping("/{id}")
    public String getEmployerPage(Model model, @PathVariable(value = "id") Integer id) {
        var employer = repository.findById(id);
        System.out.println("You hit this point!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(employer);
        if (employer.isPresent()){
            model.addAttribute("employer", employer.get());
            System.out.println("It was here////////");
            return "landing";
        }else{
            return "404";
        }
    }
}
