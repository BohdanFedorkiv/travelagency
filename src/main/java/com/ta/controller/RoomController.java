package com.ta.controller;
import com.ta.models.Hotel;
import com.ta.models.Person;
import com.ta.models.Room;
import com.ta.service.HotelService;
import com.ta.service.PersonService;
import com.ta.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;
    private final PersonService personService;

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('perm:two')")
    public String saveRoom(Model model) {
        Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("person", person);
        model.addAttribute("hotels", hotelService.allHotels());
        model.addAttribute("room", new Room());
        return "create-room";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('perm:two')")
    public String saveRoom(Model model,
            @RequestParam String hotelName,
                          @RequestParam Integer number,
                           @RequestParam Integer capacity,
                          @RequestParam Double price) {
        Hotel hotel = hotelService.getHotelByName(hotelName);
        Room room = Room.builder()
                .hotel(hotel)
                .number(number)
                .price(price)
                .capacity(capacity)
                .build();
        if (roomService.saveRoom(room)) {
            return "redirect:/home";
        } else {
            Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            model.addAttribute("person", person);
            model.addAttribute("hotels", hotelService.allHotels());
            return "create-room";
        }
    }

    @GetMapping("/allRooms/{hotel_id}")
    public String allRooms(@PathVariable("hotel_id") int hotel_id, Model model){
        List<Room> rooms = roomService.allRoomsByHotel(hotel_id);
        model.addAttribute("rooms", rooms);
        return "all-rooms";
    }
}
