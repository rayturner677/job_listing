package com.joblisting.joblisting.controllers;

import com.joblisting.joblisting.forms.CommentForm;
import com.joblisting.joblisting.forms.EmployerForm;
import com.joblisting.joblisting.repositories.PostgresCommentRepoitory;
import com.joblisting.joblisting.repositories.PostgresEmployerRepository;
import com.joblisting.joblisting.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/home")

public class LandingController {
    Repository<EmployerForm> repository;
    Repository<CommentForm> commentFormRepository;

    @Autowired
    public LandingController(PostgresEmployerRepository employerRepository, PostgresCommentRepoitory commentRepository){
        repository = employerRepository;
        commentFormRepository = commentRepository;
    }
    @GetMapping
    public String getPage(Model model){
        model.addAttribute("employers", repository.findAll());
        model.addAttribute("comments", commentFormRepository.findAll());
        return "landing";
    }

    @RequestMapping(params = "ABC", method= RequestMethod.GET)
    public String getAlphabetically(Model model){
        model.addAttribute("employers", repository.abc());
        return "landing";
    }

    @RequestMapping(params = "oldest", method= RequestMethod.GET)
    public String getOldest(Model model){
        model.addAttribute("employers", repository.oldest());
        return "landing";
    }

    @RequestMapping(params = "newest", method= RequestMethod.GET)
    public String getNewest(Model model){
        model.addAttribute("employers", repository.newest());
        return "landing";
    }

    @GetMapping("/{id}")
    public String getEmployerPage(Model model, @PathVariable(value = "id") Integer id) {
        var employer = repository.findById(id);
        System.out.println(employer);
        if (employer.isPresent()){
            model.addAttribute("employer", employer.get());
            return "employerPage";
        }else{
            return "404";
        }
    }

    @PostMapping
    public String postPage(){
        return "landing";
    }

    @PostMapping("/{employerId}/HomeComments")
    public String addComments(@PathVariable(value = "employerId") Integer employerId, CommentForm form){
        form.employer_id = employerId;
        if (form.is_valid()){
            commentFormRepository.save(form);
            return "redirect:/landing";
        }
        return "redirect:/landing";
    }
}
