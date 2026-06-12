package com.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;

import com.springboot.di.app.springboot_di.models.Product;

//@RequestScope
@Primary
@Repository
public class ProductRepository implements IProductRepository{

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Laptop i7", 1000L),
            new Product(2L, "CPU i9", 800L),
            new Product(3L, "Teclado mini", 100L),
            new Product(4l, "Mouse gamer", 150L)
        );
    }

    @Override
    public List<Product> getAll(){
        return data;
    }

    @Override
    public Product getById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}

