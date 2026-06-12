package com.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springboot.di.app.springboot_di.models.Product;
import com.springboot.di.app.springboot_di.repositories.IProductRepository;

@Service
public class ProductService implements IProductService {

    private Environment env;
    private IProductRepository repository;

    public ProductService(@Qualifier("productRepository") IProductRepository repository, Environment env) {
        this.repository = repository;
        this.env = env;
    }

    @Override
    public List<Product> getAll(){
        return repository.getAll().stream().map(p -> {
            // inmutable
            Double priceTax = p.getPrice() * env.getProperty("config.price.tax", Double.class);
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
            // p.setPrice(priceTax.longValue());
            // return p;
        }).collect(Collectors.toList());
    }
 
    @Override
    public Product getById(Long id){
        return repository.getById(id);
    }

} 