package com.springboot.jpa.springboot_jpa;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.springboot_jpa.entities.Person;
import com.springboot.jpa.springboot_jpa.repositories.IPersonRepository;

@Component
public class QueriesJPA {

    private final IPersonRepository repository;

	QueriesJPA(IPersonRepository repository) {
		this.repository = repository;
	}

    // CONSULTAS
	@Transactional(readOnly = true)
	public void findOne(){
		// Person person = null;
		// Optional<Person> optionalPerson = repository.findById(1L);
		// if(optionalPerson.isPresent()){
		// 	person = optionalPerson.get();
		// }
		// System.out.println(person);

		repository.findOne(1L).ifPresent(p -> System.out.println(p));
	}

	@Transactional(readOnly = true)
	public void findOneName(){
		//repository.findOneName("Jul").ifPresent(p -> System.out.println(p));
		repository.findByNameContaining("Jul").ifPresent(p -> System.out.println(p));
	}

	@Transactional(readOnly = true)
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
