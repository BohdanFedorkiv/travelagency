package com.ta.dao.impl;
import com.ta.dao.OrderDAO;
import com.ta.models.Hotel;
import com.ta.models.Order;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class OrderDAOImpl implements OrderDAO {
    private final SessionFactory sessionFactory;

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        //session.persist(order);
        //session.flush();
        transaction.commit();
    }

    @Override
    public void deleteOrder(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.find(Order.class, id);
        session.remove(order);
        transaction.commit();
    }

    @Override
    public List<Order> getOrderByUserId(Long person_id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createQuery("FROM Order R WHERE R.person.id = :person_id", Order.class);
            query.setParameter("person_id", person_id);
            return (List<Order>) query.getResultList();
        } catch (NullPointerException exp){
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

}
