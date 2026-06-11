package com.example.springboot_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        model.addAttribute("title", "Spring Boot");
        model.addAttribute("name", "Juliet");
        model.addAttribute("lastname", "Morales");
        return "details";
    }
}
