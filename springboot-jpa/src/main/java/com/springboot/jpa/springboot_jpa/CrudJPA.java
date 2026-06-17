package com.springboot.jpa.springboot_jpa;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.springboot_jpa.entities.Person;
import com.springboot.jpa.springboot_jpa.repositories.IPersonRepository;

@Component
public class CrudJPA {

    private final IPersonRepository repository;

	CrudJPA(IPersonRepository repository) {
		this.repository = repository;
	}

    // CRUD
	@Transactional
	public void create(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre: ");
		String name = sc.next();
		System.out.println("Ingrese el apellido: ");
		String lastname = sc.next();
		System.out.println("Ingrese el lenguaje: ");
		String programmingLanguage = sc.next();
		Person person = new Person(null, name, lastname, programmingLanguage);
		sc.close();

		Person newPerson = repository.save(person);
		System.out.println("Usuario creado: ");
		System.out.println(newPerson);

		repository.findById(newPerson.getId()).ifPresent(p -> System.out.println(p));
	}

	@Transactional
	public void update(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el id:");
		Long id = sc.nextLong();
		Optional<Person> opPerson = repository.findById(id);

		if (opPerson.isPresent()) {
			Person person = opPerson.orElseThrow();
			System.out.println(person);
			System.out.println("Ingrese el lennguaje: ");
			String programmingLanguage = sc.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person p = repository.save(person);
			System.out.println(p);
		} else {
			System.out.println("El usuario no existe");
		}
		sc.close();
	}

	@Transactional
	public void delete(){
		repository.findAll().forEach(System.out::println);
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar: ");
		Long id = sc.nextLong();

		Optional<Person> opPerson = repository.findById(id);
		opPerson.ifPresentOrElse(repository::delete,
			() -> System.out.println("No existe un usuario con ese id")
		);

		repository.findAll().forEach(System.out::println);
		sc.close();
	}
	
}
