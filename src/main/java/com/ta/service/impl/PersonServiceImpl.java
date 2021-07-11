package com.ta.service.impl;
import com.ta.dao.PersonDAO;
import com.ta.models.Person;
import com.ta.models.Role;
import com.ta.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.resource.spi.work.SecurityContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Transactional
@Service
        //("userServiceImpl")
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

//    @Override
//    public boolean savePerson(Person person) {
//        Optional<Person> per = personDAO.getPersonByEmail(person.getEmail());
//        if(per.isPresent()){
//            return false;
//        } else {
//            person.setRole(Role.USER);
//            personDAO.savePerson(person);
//            return true;
//        }
//    }


    @Override
    public boolean savePerson(Person person) {
        Optional<Person> per = personDAO.getPersonByEmail(person.getEmail());
        if(per.isPresent()){
            return false;
        } else {
            person.setRole(Role.USER);
            person.setEncryptedPassword(new BCryptPasswordEncoder().encode(person.getPassword()));
            personDAO.savePerson(person);
            return true;
        }
    }

    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personDAO.getPersonByEmail(email).orElse(null);
    }

    @Override
    public Person getPersonById(Long id) {
        return personDAO.getPersonById(id).orElse(null);
    }

    @Override
    public void deletePerson(Long id) {
        personDAO.deletePerson(id);
    }

    @Override
    public Person getEmail(String email) {
        return personDAO.getEmail(email);
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Person person = personDAO.getEmail(email);
//        if (person == null) {
//            throw new UsernameNotFoundException("Invalid username of password.");
//        }
//        return person;
//    }

}
