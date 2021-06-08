package com.ta.service.impl;
import com.ta.dao.RoomDAO;
import com.ta.models.Hotel;
import com.ta.models.Room;
import com.ta.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomDAO roomDAO;

    @Override
    public boolean saveRoom(Room room) {
        roomDAO.saveRoom(room);
        return true;
    }

    @Override
    public List<Room> allRooms(int hotel_id) {
        return roomDAO.allRooms(hotel_id);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    @Override
    public Room getRoomById(long id) {
        return roomDAO.getRoomById(id).orElse(null);
    }
}
