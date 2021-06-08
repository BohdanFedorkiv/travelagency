package com.ta.service;
import com.ta.models.Room;

import java.util.List;
import java.util.Optional;


public interface RoomService {
    boolean saveRoom(Room room);

    List<Room> allRooms(int hotel_id);

    List<Room> getAllRooms();

    Room getRoomById(long id);
}
