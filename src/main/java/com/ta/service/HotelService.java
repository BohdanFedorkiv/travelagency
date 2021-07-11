package com.ta.service;
import com.ta.models.Hotel;
import java.util.List;


public interface HotelService {
    boolean saveHotel(Hotel hotel);

    List<Hotel> allHotels();

    List<Hotel> searchHotelByCountryOrCity(String name);

    Hotel getHotelByName(String name);

    Hotel getHotelById(Long id);

    void deleteHotel(Long id);

}
