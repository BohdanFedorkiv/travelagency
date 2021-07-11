package com.ta.dao.impl;
import com.ta.dao.HotelDAO;
import com.ta.models.Hotel;
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
public class HotelDAOImpl implements HotelDAO {
    private final SessionFactory sessionFactory;

    @Override
    public void saveHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(hotel);
        transaction.commit();
    }

    @Override
    public List<Hotel> allHotels() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("from Hotel", Hotel.class);
            return (List<Hotel>) query.getResultList();
        }catch (NullPointerException e){
            return new ArrayList<>();
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<Hotel> searchHotelByCountryOrCity(String name) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Hotel where lower(country) like :theCountry or lower(city) like :theCountry", Hotel.class);
            query.setParameter("theCountry", "%" + name.toLowerCase() + "%");
            return (List<Hotel>) query.getResultList();
        } catch (NullPointerException exp) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<Hotel> getHotelByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("FROM Hotel H WHERE H.name = :name", Hotel.class);
            query.setParameter("name", name);
            List result = query.getResultList();
            if (result.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of((Hotel) result.get(0));
        } catch (NullPointerException exp) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public void deleteHotel(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Hotel hotel = session.find(Hotel.class, id);
        session.remove(hotel);
        transaction.commit();
    }

    @Override
    public Optional<Hotel> getHotelById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Hotel hotel = session.get(Hotel.class, id);
            return Optional.of(hotel);
        }catch (NullPointerException exp) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }
}
