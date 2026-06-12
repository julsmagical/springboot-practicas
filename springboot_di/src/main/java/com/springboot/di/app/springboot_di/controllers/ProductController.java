package com.springboot.di.app.springboot_di.controllers;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.di.app.springboot_di.models.Product;
import com.springboot.di.app.springboot_di.services.IProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    //@Autowired
    private IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product>list(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return service.getById(id);
    }
}
