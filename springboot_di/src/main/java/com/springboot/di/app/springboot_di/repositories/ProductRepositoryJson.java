package com.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.springboot.di.app.springboot_di.models.Product;

import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements IProductRepository {

    private List<Product> products;

    // public ProductRepositoryJson() {
    //     Resource resource = new ClassPathResource("json/product.json");
    //     readValueJson(resource);
    // }

    public ProductRepositoryJson(Resource resource) {
        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            products = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     @Override
     public List<Product> getAll(){
        return products;
     }
 
     @Override
     public Product getById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
     }

}
