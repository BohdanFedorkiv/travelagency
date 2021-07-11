package com.ta.service;
import com.ta.models.Person;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface PersonService
//        extends UserDetailsService
{
    boolean savePerson(Person person);

    List<Person> getAllPersons();

    Person getPersonByEmail(String email);

    Person getPersonById(Long id);

    void deletePerson(Long id);

    Person getEmail(String email);

}
