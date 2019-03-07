package com.joblisting.joblisting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")

public class EmployerController {
    @GetMapping("/employer")
    public String getEmployer(){return "employer";}
}
