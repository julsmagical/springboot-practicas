package com.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.di.app.springboot_di.models.Product;
import com.springboot.di.app.springboot_di.repositories.IProductRepository;

@Component
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> getAll(){
        return repository.getAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }
 
    @Override
    public Product getById(Long id){
        return repository.getById(id);
    }
} 