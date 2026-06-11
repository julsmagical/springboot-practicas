package com.example.springboot_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot_demo.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Juliet", "Morales", "juliet@gmail.com", 20);
        model.addAttribute("title", "Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }
}
