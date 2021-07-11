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
import java.util.Optional;


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
    public Optional<Person> getPersonByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Person P WHERE P.email = :email", Person.class);
            query.setParameter("email", email);
            Person person = (Person) query.uniqueResult();
            return Optional.of(person);
        } catch (NullPointerException exp) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Person> getAllPersons() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("from Person", Person.class);
            return (List<Person>) query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Person person = session.get(Person.class, id);
            return Optional.of(person);
        } catch (NullPointerException exp) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public void deletePerson(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Person where id = :id", Person.class);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public Person getEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query<Person> theQuery = session.createQuery("from Person where email=:email", Person.class);
        theQuery.setParameter("email", email);

        Person theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        } finally {
            transaction.commit();
        }

        return theUser;
    }
}
/*
Как обычно, в данном коде класс DAO объявляется как компонент Spring Bean с
помощью аннотации @Repository. В
 */
