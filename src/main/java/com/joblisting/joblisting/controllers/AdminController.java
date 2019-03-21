package com.joblisting.joblisting.controllers;

import com.joblisting.joblisting.forms.CommentForm;
import com.joblisting.joblisting.forms.DeleteForm;
import com.joblisting.joblisting.forms.EmployerForm;
import com.joblisting.joblisting.repositories.PostgresEmployerRepository;
import com.joblisting.joblisting.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping
    public String postPage() {
        return "admin";
    }

    @PostMapping("/{id}/delete")
    public String deleteEmployer(@PathVariable(value = "id" )Integer id) {
        if (id != null) {
            repository.delete(id);
            return "redirect:/admin";
        }
        return "admin";
    }

    @PostMapping("/{id}/comments")
    public String PostComments(@PathVariable(value = "id") Integer id, PostgresEmployerRepository employerRepository){
        return "admin";
    }
}