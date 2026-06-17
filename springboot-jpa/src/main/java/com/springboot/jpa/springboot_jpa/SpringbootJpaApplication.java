package com.springboot.jpa.springboot_jpa;

import java.util.List;
//import java.util.Optional;

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
		list();
		//findOneName();
	}

	public void findOne(){
		// Person person = null;
		// Optional<Person> optionalPerson = repository.findById(1L);
		// if(optionalPerson.isPresent()){
		// 	person = optionalPerson.get();
		// }
		// System.out.println(person);

		repository.findOne(1L).ifPresent(p -> System.out.println(p));
	}

	public void findOneName(){
		//repository.findOneName("Jul").ifPresent(p -> System.out.println(p));
		repository.findByNameContaining("Jul").ifPresent(p -> System.out.println(p));
	}

	public void list(){
		// List<Person> persons = (List<Person>) repository.findAll();
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguage("Java");
		// List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("Java", "Roe");
		persons.stream().forEach(person -> System.out.println(person));

		// campos separados
		List<Object[]> personValue = repository.obtenerPersonData("Java");
		personValue.stream().forEach(person -> {
			System.out.println(person[0] + " " + person[1] + " es experto en " + person[2]);
		});
	}
}
