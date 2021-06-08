package com.ta.service.impl;
import com.ta.dao.PersonDAO;
import com.ta.models.Person;
import com.ta.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }
}
