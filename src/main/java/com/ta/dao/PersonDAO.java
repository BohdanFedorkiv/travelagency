package com.ta.dao;
import com.ta.models.Person;

import java.util.List;
import java.util.Optional;


public interface PersonDAO {
    void savePerson(Person person);

    List<Person> getAllPersons();

    Optional<Person> getPersonByEmail(String email);

    Optional<Person> getPersonById(Long id);

    void deletePerson(Long id);

    Person getEmail(String email);
}
