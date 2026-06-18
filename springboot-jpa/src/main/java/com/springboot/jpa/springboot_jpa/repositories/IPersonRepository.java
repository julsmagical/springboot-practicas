package com.springboot.jpa.springboot_jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.springboot.jpa.springboot_jpa.entities.Person;

public interface IPersonRepository extends CrudRepository<Person, Long> {
    
    // Obtener uno
    @Query("SELECT p FROM Person p WHERE p.id=?1")
    Optional<Person> findOne(Long id);

    @Query("SELECT p FROM Person p WHERE p.name LIKE %?1%")
    Optional<Person> findOneName(String name);

    Optional<Person> findByNameContaining(String name);

    // consultas JPA y personalizadas
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT p FROM Person p WHERE p.programmingLanguage=?1 AND p.lastname=?2")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String lastname);

    // Obtener campos separados
    @Query("SELECT p.name, p.programmingLanguage FROM Person p")
    List<Object[]> obtenerPersonData();

    // con busqueda parcial
    @Query("SELECT p.name, p.lastname, p.programmingLanguage FROM Person p WHERE p.programmingLanguage LIKE %?1%")
    List<Object[]> obtenerPersonData(String programmingLanguage);

    @Query("SELECT p.lastname, p.programmingLanguage FROM Person p WHERE p.programmingLanguage=?1 AND p.name=?2")
    List<Object[]> obtenerPersonData(String programmingLanguage, String name);

    // Consultas personalizadas
    @Query("SELECT CONCAT(p.name, ' ', p.lastname) AS fullname FROM Person p WHERE p.id=?1")
    String getFullNameById(Long id);

    //obtener un solo elementos por el id
    @Query("SELECT p.id, p.name, p.lastname, p.programmingLanguage FROM Person p WHERE p.id=?1")
    List<Object[]>  getFullObject(Long id);

    @Query("SELECT p, p.programmingLanguage from Person p")
    List<Object[]> getFullList();

    @Query("SELECT new Person(p.name, p.lastname) FROM Person p")
    List<Person> findAllPersonalizedPerson();

    // con DTO
    @Query("SELECT new com.springboot.jpa.springboot_jpa.dto.PersonDto(p.name, p.lastname) FROM Person p")
    List<PersonDto> findAllPersonDto();

    // con distinct para evitar repeticion
    @Query("SELECT DISTINCT (p.programmingLanguage) FROM Person p")
    List<String> findAllProgrammingLanguage();

    @Query("SELECT COUNT (DISTINCT(p.programmingLanguage)) FROM Person p")
    Long countProgrammingLanguage();

    // concat, upper, lower y like
    @Query("SELECT DISTINCT UPPER(p.name || ' ' || p.lastname) FROM Person p")
    List<String> findAllNames();

    // between
    @Query("SELECT p FROM Person p WHERE p.id BETWEEN ?1 AND ?2")
    List<Person> findIdBetween(Long id1, Long id2);

    @Query("SELECT p FROM Person p WHERE p.name BETWEEN ?1 AND ?2 ORDER BY p.name DESC")
    List<Person> findNameBetween(String c1, String c2);

    List<Person> findById(Long id1, Long id2);
    List<Person> findByName(String name1, String name2);

    // jpql de agregación
    @Query("SELECT COUNT(p) FROM Person p")
    Long totalPerson();

    @Query("SELECT MIN(p.id) FROM Person p")
    Long minId();

    @Query("SELECT MAX(p.id) FROM Person p")
    Long maxId();

    @Query("SELECT p.name, LENGTH(p.name) FROM Person p")
    public List<Object[]> getNameLength();

    @Query("SELECT MIN(p.id), MAX(p.id), SUM(p.id), AVG(LENGTH(p.name)), COUNT(p.id) FROM Person p")
    public Object getAggregationFunctions();

    @Query("SELECT p.name, LENGTH(p.name) FROM Person p WHERE LENGTH(p.name)=(SELECT MIN(LENGTH(p.name)) FROM Person p)")
    public List<Object[]> getShorterName();

    //ultimo registro
    @Query("SELECT p FROM Person p WHERE p.id=(SELECT MAX(p.id) FROM Person p)")
    public Optional<Person> getLastRegistration();

    @Query("SELECT p FROM Person p WHERE p.id IN ?1")
    public List<Person> getPersonsByIds(List<Long> ids);
}
