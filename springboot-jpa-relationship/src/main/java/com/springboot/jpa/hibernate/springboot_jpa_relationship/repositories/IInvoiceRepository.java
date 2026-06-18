package com.springboot.jpa.hibernate.springboot_jpa_relationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.hibernate.springboot_jpa_relationship.entities.Invoice;

public interface IInvoiceRepository extends CrudRepository<Invoice, Long>{

}
