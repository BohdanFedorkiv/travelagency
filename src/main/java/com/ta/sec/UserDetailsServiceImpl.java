package com.ta.sec;
import com.ta.dao.PersonDAO;
import com.ta.dao.impl.PersonDAOImpl;
import com.ta.models.Person;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PersonDAOImpl personDAO;

    public UserDetailsServiceImpl(PersonDAOImpl personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = personDAO.getPersonByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        return SecurityUser.fromUser(person);
    }
}
