package com.example.springboot_demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.springboot_demo.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Juliet", "Morales", "juliet@gmail.com", 20);
        model.addAttribute("title", "Spring Boot");
        model.addAttribute("user", user);
        user.setPhone("123456789");
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel(){
        List<User> users = Arrays.asList(
            new User("Juliet", "Morales", "juliet@gmail.com", 20),
            new User("Juliet2", "Morales", "juliet2@gmail.com", 20),
            new User("Juliet3", "Morales", "juliet3@gmail.com", 20));
        return users;
    }
    
}
