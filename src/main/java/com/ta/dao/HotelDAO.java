package com.ta.dao;
import com.ta.models.Hotel;
import java.util.List;
import java.util.Optional;


public interface HotelDAO {
    void saveHotel(Hotel hotel);

    List<Hotel> allHotels();

    List<Hotel> searchHotelByCountryOrCity(String name);

    Optional<Hotel> getHotelByName(String name);

    Optional<Hotel> getHotelById(Long id);

    void deleteHotel(Long id);
}
