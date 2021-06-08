package com.ta.dao.impl;
import com.ta.dao.OrderDAO;
import com.ta.models.Order;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class OrderDAOImpl implements OrderDAO {
    private final SessionFactory sessionFactory;

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //session.save(order);
        session.persist(order);
        session.flush();
        transaction.commit();
    }
}
