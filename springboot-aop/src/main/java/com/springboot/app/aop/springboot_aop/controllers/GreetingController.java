package com.springboot.app.aop.springboot_aop.controllers;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.aop.springboot_aop.services.IGreetingService;

@RestController
public class GreetingController {

    //autowired con constructor
    private final IGreetingService greetingService;

    GreetingController(IGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("Juan", "Hola")));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHelloError("Juan", "Hola")));
    }
}
