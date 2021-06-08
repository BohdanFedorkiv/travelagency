package com.ta.dao.impl;
import com.ta.dao.RoomDAO;
import com.ta.models.Hotel;
import com.ta.models.Room;
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
public class RoomDAOImpl implements RoomDAO {
    private final SessionFactory sessionFactory;

    @Override
    public void saveRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
    }

    @Override
    public List<Room> allRooms(int hotel_id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("from Room where hotel_id = :hotel_id", Room.class);
            query.setParameter("hotel_id", hotel_id);
            return query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Room> getAllRooms() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("from Room", Room.class);
            return (List<Room>) query.getResultList();
        }catch (NullPointerException e){
            return new ArrayList<>();
        }finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<Room> getRoomById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Room room = session.get(Room.class, id);
            return Optional.of(room);
        }catch (NullPointerException npe) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }

}
