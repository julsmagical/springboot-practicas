package com.springboot.jpa.springboot_jpa;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.springboot_jpa.entities.Person;
import com.springboot.jpa.springboot_jpa.repositories.IPersonRepository;

@Component
public class PersonalizedQueries {

    private final IPersonRepository repository;

	PersonalizedQueries(IPersonRepository repository) {
		this.repository = repository;
	}

    // CONSULTAS PERSONALIZADAS
    @Transactional(readOnly = true)
	public void findFullnameById(){
        String fullname = repository.getFullNameById(8L);
        System.out.println(fullname);
    }

    @Transactional(readOnly = true)
	public void findFullObject(){
        System.out.println("==== Consulta por el id para mostrar la lista ====");
		List<Object[]> personObject = repository.getFullObject(6L);
        personObject.stream().forEach(person -> {
			System.out.println(String.valueOf(person[0]) + ": " + String.valueOf(person[1]) + " " + String.valueOf(person[2]) + " es experto en " + String.valueOf(person[3]));
		});
    }

    @Transactional(readOnly = true)
    public void findFullList(){
        System.out.println("==== Consulta por objeto persona y lenguaje ====");
        List<Object[]> personList = repository.getFullList();
        personList.forEach(pr -> {
            System.out.println("programmingLanguage=" + pr[1] + ", person=" + pr[0]);
        });

        System.out.println("==== Consulta que puebla y devuelve objeto entity de una instancia personalizada ====");
        List<Person> persons = repository.findAllPersonalizedPerson();
        persons.forEach(System.out::println);
    }
}
