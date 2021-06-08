package com.ta.dao;
import com.ta.models.Room;
import java.util.List;
import java.util.Optional;


public interface RoomDAO {
    void saveRoom(Room room);

    List<Room> allRooms(int hotel_id);

    List<Room> getAllRooms();

    Optional<Room> getRoomById(long id);
}
