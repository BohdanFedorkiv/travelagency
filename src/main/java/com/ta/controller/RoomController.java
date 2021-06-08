package com.ta.controller;
import com.ta.models.Hotel;
import com.ta.models.Room;
import com.ta.service.HotelService;
import com.ta.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;

    @GetMapping("/create")
    public String saveRoom(Model model) {
        model.addAttribute("hotels", hotelService.allHotels());
        model.addAttribute("room", new Room());
        return "create-room";
    }

    @PostMapping("/create")
    public String saveRoom(Model model,
            @RequestParam String hotelName,
                          @RequestParam Integer number,
                           @RequestParam Integer capacity,
                          @RequestParam Double price,
                          @RequestParam Boolean available) {
        Hotel hotel = hotelService.getHotel(hotelName);
        Room room = Room.builder()
                .hotel(hotel)
                .number(number)
                .price(price)
                .capacity(capacity)
                .available(available)
                .build();
        if (roomService.saveRoom(room)) {
            return "redirect:/home";
        } else {
            model.addAttribute("hotels", hotelService.allHotels());
            return "create-room";
        }
    }

    @GetMapping("/allRooms/{hotel_id}")
    public String allRooms(@PathVariable("hotel_id") int hotel_id, Model model){
        List<Room> rooms = roomService.allRooms(hotel_id);
        model.addAttribute("rooms", rooms);
        return "all-rooms";
    }

}
