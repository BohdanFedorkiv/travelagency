package com.ta.service.impl;
import com.ta.dao.HotelDAO;
import com.ta.models.Hotel;
import com.ta.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Transactional
@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelDAO hotelDAO;

    @Override
    public boolean saveHotel(Hotel hotel) {
        if(Objects.nonNull(getHotelByName(hotel.getName()))){
            return false;
        }
        hotelDAO.saveHotel(hotel);
        return true;
    }

    @Override
    public List<Hotel> allHotels() {
        return hotelDAO.allHotels();
    }

    @Override
    public List<Hotel> searchHotelByCountryOrCity(String name) {
        return hotelDAO.searchHotelByCountryOrCity(name);
    }

    @Override
    public Hotel getHotelByName(String name) {
        return hotelDAO.getHotelByName(name).orElse(null);
    }

    @Override
    public void deleteHotel(Long id) {
        hotelDAO.deleteHotel(id);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelDAO.getHotelById(id).orElse(null);
    }
}
