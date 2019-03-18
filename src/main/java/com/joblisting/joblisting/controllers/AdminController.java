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
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
    Repository<EmployerForm> repository;

    @Autowired
    public AdminController(PostgresEmployerRepository employerRepository){
        repository = employerRepository;
    }
    @GetMapping
    public String renderPage(Model model){
        model.addAttribute("employers", repository.findAll());
        return "admin";
    }

    @RequestMapping(params = "delete", method= RequestMethod.GET)
    @GetMapping
    public String delete(EmployerForm form){
        repository.delete(form);
        return "admin";
    }

    @PostMapping
    public String postPage(){
        return "admin";
    }
}
