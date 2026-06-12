package com.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.springboot.di.app.springboot_di.models.Product;

@Primary
@Repository
public class ProductRepositoryGeneric implements IProductRepository {

     @Override
     public List<Product> getAll(){
         return Collections.singletonList(new Product(1L, "Producto generico", 100L));
     }
 
     @Override
     public Product getById(Long id){
        return new Product(id, "Monitor generico", 100L);
     }
}