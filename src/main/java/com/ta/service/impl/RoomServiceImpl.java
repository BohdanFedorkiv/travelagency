package com.ta.service.impl;
import com.ta.dao.RoomDAO;
import com.ta.models.Room;
import com.ta.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Transactional
@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomDAO roomDAO;

    @Override
    public boolean saveRoom(Room room) {
        if(Objects.nonNull(room)){
            roomDAO.saveRoom(room);
            return true;
        }
        return false;
    }

    @Override
    public List<Room> allRoomsByHotel(int hotel_id) {
        return roomDAO.allRoomsByHotel(hotel_id);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    @Override
    public Room getRoomById(long id) {
        return roomDAO.getRoomById(id).orElse(null);
    }

    @Override
    public void deleteRoom(Long id) {
        roomDAO.deleteRoom(id);
    }

    @Override
    public List<Room> getAvailableRooms(LocalDate checkin, LocalDate checkout) {
        return roomDAO.getAvailableRooms(checkin, checkout);
    }
}
