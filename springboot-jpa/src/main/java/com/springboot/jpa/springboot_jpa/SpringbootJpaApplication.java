package com.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
		delete();
	}

	// CRUD9
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
