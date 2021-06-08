package com.ta.dao.impl;
import com.ta.dao.PersonDAO;
import com.ta.models.Person;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
@AllArgsConstructor
public class PersonDAOImpl implements PersonDAO {
    private final SessionFactory sessionFactory;

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
    }

    @Override
    public List<Person> getAllPersons() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createQuery("from Person", Person.class);
            return (List<Person>) query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }
}

/*
Как обычно, в данном коде класс DAO объявляется как компонент Spring Bean с
помощью аннотации @Repository. В
 */
