package com.ta.service;
import com.ta.models.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface RoomService {
    boolean saveRoom(Room room);

    List<Room> allRoomsByHotel(int hotel_id);

    List<Room> getAllRooms();

    Room getRoomById(long id);

    void deleteRoom(Long id);

    List<Room> getAvailableRooms(LocalDate checkin,
                                 LocalDate checkout);
}
