package com.ta.service.impl;
import com.ta.dao.HotelDAO;
import com.ta.models.Hotel;
import com.ta.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelDAO hotelDAO;

    @Override
    public void saveHotel(Hotel hotel) {
        hotelDAO.saveHotel(hotel);
    }

    @Override
    public List<Hotel> allHotels() {
        return hotelDAO.allHotels();
    }

    @Override
    public List<Hotel> searchHotelByCountry(String countryName) {
        return hotelDAO.searchHotelByCountry(countryName);
    }

    @Override
    public Hotel getHotel(String name) {
        return hotelDAO.getHotel(name).orElse(null);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelDAO.deleteHotel(id);
    }

}
