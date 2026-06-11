package com.example.springboot_demo.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.models.User;
import com.example.springboot_demo.models.dto.UserDto;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping(path="/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        User user = new User("Juliet", "Morales", "juliet@gmail.com", 20);
        userDto.setUser(user);
        userDto.setTitle("Spring Boot");
        
        return userDto;
    }
    
    @GetMapping(path="/list")
    public List<User> list(){
        User user = new User("Juliet", "Morales", "juliet@gmail.com", 20);
        User user2 = new User("Juliet2", "Morales2", "juliet2@gmail.com", 20);
        User user3 = new User("Juliet3", "Morales2", "juliet3@gmail.com", 20);

        List<User> users = Arrays.asList(user, user2, user3);
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }

    @GetMapping(path="/details-map")
    public Map<String, Object> detailsMap(){
        User user = new User("Juliet", "Morales", "juliet@gmail.com", 20);
        Map<String, Object> body = new HashMap<>();
        
        body.put("title", "Spring Boot");
        body.put("user", user);
        return body;
    }
} 
