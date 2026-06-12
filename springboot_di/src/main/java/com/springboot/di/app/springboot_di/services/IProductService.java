package com.springboot.di.app.springboot_di.services;

import java.util.List;

import com.springboot.di.app.springboot_di.models.Product;

public interface IProductService {

    List<Product> getAll();
    Product getById(Long id);
}
