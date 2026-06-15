package com.springboot.di.factura.springboot_factura_di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.di.factura.springboot_factura_di.models.Client;
import com.springboot.di.factura.springboot_factura_di.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show(){
        Invoice i = new Invoice();
        Client c = new Client();
        c.setName(invoice.getClient().getName());
        c.setLastName((invoice.getClient().getLastName()));
        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems((invoice.getItems()));

        return i;
    }
}
