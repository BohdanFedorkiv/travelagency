package com.ta.service;
import com.ta.models.Hotel;
import java.util.List;


public interface HotelService {
    void saveHotel(Hotel hotel);

    List<Hotel> allHotels();

    List<Hotel> searchHotelByCountry(String countryName);

    Hotel getHotel(String name);

    void deleteHotel(Long id);

}
