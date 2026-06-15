package com.springboot.schedule.interceptor.schedule_interceptor.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AppController {

    @GetMapping("/app")
    public ResponseEntity<?> app(HttpServletRequest request){
        Map<String, Object> data = new HashMap<>();
        data.put("title", "Bienvenidos al sistema de atención");
        data.put("date", new Date());
        data.put("message", request.getAttribute("message"));
        return ResponseEntity.ok(data);
    }
}
