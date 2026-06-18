package com.springboot.jpa.hibernate.springboot_jpa_relationship.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.hibernate.springboot_jpa_relationship.entities.Address;
import com.springboot.jpa.hibernate.springboot_jpa_relationship.entities.Client;
import com.springboot.jpa.hibernate.springboot_jpa_relationship.repositories.IClientRepository;
import com.springboot.jpa.hibernate.springboot_jpa_relationship.repositories.IInvoiceRepository;

@Service
public class OneToManyService {

    private final IClientRepository clientRepository;
    private final IInvoiceRepository invoiceRepository;  

    OneToManyService(IClientRepository clientRepository, IInvoiceRepository invoiceRepository) {
        this.clientRepository = clientRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public void createClientAddress(){
        Client client = new Client("Francisco", "Fernandez");
        
        Address ad1 = new Address("Urdesa norte", 1246);
        Address ad2 = new Address("La florida", 3826);
    
        client.getAddresses().add(ad1);
        client.getAddresses().add(ad2);

        clientRepository.save(client);

        System.out.println(client);
    }

    @Transactional
    public void findById(){
        Optional<Client> opClient = clientRepository.findById(2L);
        opClient.ifPresent(client -> {
            Address ad1 = new Address("Urdesa sur", 1246);
            Address ad2 = new Address("La florida", 3826);
        
            client.getAddresses().clear();
            client.getAddresses().add(ad1);
            client.getAddresses().add(ad2);

            System.out.println(client);
        });
        
    }
}
