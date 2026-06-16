package com.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.springboot_jpa.entities.Person;

public interface IPersonRepository extends CrudRepository<Person, Long> {
    
}
