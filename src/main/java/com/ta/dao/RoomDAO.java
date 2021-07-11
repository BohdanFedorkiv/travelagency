package com.ta.dao;
import com.ta.models.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface RoomDAO {
    void saveRoom(Room room);

    List<Room> allRoomsByHotel(int hotel_id);

    List<Room> getAllRooms();

    Optional<Room> getRoomById(long id);

    void deleteRoom(Long id);

    List<Room> getAvailableRooms(LocalDate checkin,
                                        LocalDate checkout);
}
