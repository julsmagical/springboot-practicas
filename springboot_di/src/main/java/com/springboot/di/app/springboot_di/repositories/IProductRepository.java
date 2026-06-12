package com.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.springboot.di.app.springboot_di.models.Product;

public interface IProductRepository {

    List<Product> getAll();
    Product getById(Long id);
}
