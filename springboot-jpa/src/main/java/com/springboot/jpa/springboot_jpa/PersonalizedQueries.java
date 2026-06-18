package com.springboot.jpa.springboot_jpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.springboot_jpa.dto.PersonDto;
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

        System.out.println("==== Consulta que puebla y devuelve un dto ====");
        List<PersonDto> personsDto = repository.findAllPersonDto();
        personsDto.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void queriesDistint(){
        System.out.println("==== Consulta con lenguages de programación ====");
        List<String> language = repository.findAllProgrammingLanguage();
        language.forEach(System.out::println);

        System.out.println("==== Consulta con total de lenguages de programación ====");
        Long totalLanguage = repository.countProgrammingLanguage();
        System.out.println("Total de lenguajes de programación: " + totalLanguage);
    }

    @Transactional(readOnly = true)
    public void personalizedFunctions(){
        System.out.println("==== Consulta con nombres y funciones ====");
        List<String> names = repository.findAllNames();
        names.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void personalizedBetween(){
        System.out.println("==== Consulta por rangos ====");
        List<Person> persons = repository.findIdBetween(2L, 5L);
        persons.forEach(System.out::println);

        System.out.println("==== Consulta por nombres ====");
        List<Person> names = repository.findNameBetween("J", "P");
        names.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void functionAggregation(){
        System.out.println("==== Consulta con el total ====");
        Long count = repository.totalPerson();
        System.out.println(count);
        System.out.println(count);

        System.out.println("==== Consulta con el total ====");
        Long min = repository.minId();
        System.out.println(min);
       
        System.out.println("==== Consulta con el total ====");
        Long max = repository.maxId(); 
        System.out.println(max);

        System.out.println("==== Consulta con el largo del nombre ====");
        List<Object[]> regs = repository.getNameLength();
        regs.forEach(reg -> {
            String name = (String) reg[0];
            Integer length = (Integer) reg[1];
            System.out.println("name=" + name + ", length=" + length);
        });

        System.out.println("==== Resumen de consultas ====");
        Object[] resume = (Object[]) repository.getAggregationFunctions();
        System.out.println(
            "min=" + resume[0] + 
            ", max=" + resume[1] + 
            ", sum=" + resume[2] + 
            ", avg=" + resume[3] + 
            ", count=" + resume[4]);
    }

    @Transactional(readOnly = true)
    public void subQueries(){
        System.out.println("==== Subconsulta nombre más corto y largo ====");
        List<Object[]> regs = repository.getShorterName();
        regs.forEach(reg -> {
            String name = (String) reg[0];
            Integer length = (Integer) reg[1];
            System.out.println("name=" + name + ", length=" + length);
        });
        System.out.println("==== Subconsulta  para obtener ultimo registro ====");
        Optional<Person> opPerson = repository.getLastRegistration();
        opPerson.ifPresent(System.out::println);
    }

    @Transactional(readOnly = true)
    public void whereIn(){
        System.out.println("==== Consulta where in ====");
        List<Person> persons = repository.getPersonsByIds(List.of(1L, 2L, 4L));
        persons.forEach(System.out::println);
    }
}
