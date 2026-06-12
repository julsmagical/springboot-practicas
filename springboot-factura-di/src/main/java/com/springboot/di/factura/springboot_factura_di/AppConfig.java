package com.springboot.di.factura.springboot_factura_di;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.springboot.di.factura.springboot_factura_di.models.Item;
import com.springboot.di.factura.springboot_factura_di.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("PC Gamer", 1200.00);
        Product p2 = new Product("Tablet", 500.00);
        return List.of(new Item(p1, 2), new Item(p2, 3));
    }

    @Primary
    @Bean
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Monitor ASUS", 80.70);
        Product p2 = new Product("Impresora L1250", 200.00);
        Product p3 = new Product("Notebook Pro", 124.99);
        Product p4 = new Product("Impresora HP", 300.00);
        return List.of(new Item(p1, 2), new Item(p2, 3), new Item(p3, 3), new Item(p4, 5));
    }
} 