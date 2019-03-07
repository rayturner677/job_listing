package com.joblisting.joblisting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")

public class LandingController {
    @GetMapping("/")
    public String index() {return "landing";}

    @GetMapping("/employer")
    public String getEmployer(){return "employer";}

    @GetMapping("/admin")
    public String getAdmin() {return "admin";}
}
