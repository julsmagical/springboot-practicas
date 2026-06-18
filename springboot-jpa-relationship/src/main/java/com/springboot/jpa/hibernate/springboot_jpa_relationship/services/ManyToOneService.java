package com.springboot.jpa.hibernate.springboot_jpa_relationship.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.jpa.hibernate.springboot_jpa_relationship.entities.Client;
import com.springboot.jpa.hibernate.springboot_jpa_relationship.entities.Invoice;
import com.springboot.jpa.hibernate.springboot_jpa_relationship.repositories.IClientRepository;
import com.springboot.jpa.hibernate.springboot_jpa_relationship.repositories.IInvoiceRepository;

@Service
public class ManyToOneService {

    private final IClientRepository clientRepository;
    private final IInvoiceRepository invoiceRepository;  

    ManyToOneService(IClientRepository clientRepository, IInvoiceRepository invoiceRepository) {
        this.clientRepository = clientRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public void createClient(){
        Client client = new Client("Juliet", "Morales");
        clientRepository.save(client);

        Invoice invoice = new Invoice("compras de oficina", 200L);
        invoice.setClient(client);
        Invoice invoiceDB = invoiceRepository.save(invoice);
        System.out.println(invoiceDB);
    }

    public void findById(){
        Optional<Client> opClient = clientRepository.findById(2L);

        if (opClient.isPresent()){
            Client client = opClient.orElseThrow();

            Invoice invoice = new Invoice("compras de oficina", 200L);
            invoice.setClient(client);
            Invoice invoiceDB = invoiceRepository.save(invoice);
            System.out.println(invoiceDB);
        }
    }
}
