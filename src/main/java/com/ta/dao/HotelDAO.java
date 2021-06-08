package com.ta.dao;
import com.ta.models.Hotel;

import java.util.List;
import java.util.Optional;


public interface HotelDAO {
    void saveHotel(Hotel hotel);

    List<Hotel> allHotels();

    List<Hotel> searchHotelByCountry(String country);

    Optional<Hotel> getHotel(String name);

    void deleteHotel(Long id);

}
