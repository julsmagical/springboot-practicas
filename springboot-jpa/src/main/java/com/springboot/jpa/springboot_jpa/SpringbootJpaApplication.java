package com.springboot.jpa.springboot_jpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.jpa.springboot_jpa.entities.Person;
import com.springboot.jpa.springboot_jpa.repositories.IPersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	private final IPersonRepository repository;

	SpringbootJpaApplication(IPersonRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Person> persons = (List<Person>) repository.findAll();
		persons.stream().forEach(person -> System.out.println(person));
	}
}
