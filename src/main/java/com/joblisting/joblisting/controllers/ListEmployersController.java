package com.joblisting.joblisting.controllers;

import com.joblisting.joblisting.forms.EmployerForm;
import com.joblisting.joblisting.repositories.PostgresEmployerRepository;
import com.joblisting.joblisting.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListEmployersController {
    Repository<EmployerForm> repository;

    @Autowired
    public ListEmployersController(PostgresEmployerRepository employerRepository){
        repository = employerRepository;
    }
    @GetMapping
    public String getPage(Model model){
        model.addAttribute("employers", repository.findAll());
        return "ListEmployers";
}

    @PostMapping
    public String postPage(){
        return "ListEmployers";
    }
}
