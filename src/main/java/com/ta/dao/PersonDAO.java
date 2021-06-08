package com.ta.dao;
import com.ta.models.Person;

import java.util.List;


public interface PersonDAO {
    void savePerson(Person person);

    List<Person> getAllPersons();
}
