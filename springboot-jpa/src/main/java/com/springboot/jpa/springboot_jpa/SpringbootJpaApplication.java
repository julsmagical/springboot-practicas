package com.springboot.jpa.springboot_jpa;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.jpa.springboot_jpa.repositories.IPersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	private final IPersonRepository repository;
	private final QueriesJPA queries;
	private final CrudJPA crud;

	SpringbootJpaApplication(IPersonRepository repository, QueriesJPA queries, CrudJPA crud) {
		this.repository = repository;
		this.queries = queries;
		this.crud = crud;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//queries.list();
		crud.update();
	}
}
