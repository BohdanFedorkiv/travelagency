package com.ta.controller;
import com.ta.models.Hotel;
import com.ta.models.Person;
import com.ta.service.HotelService;
import com.ta.service.PersonService;
import com.ta.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final PersonService personService;
    private final RoomService roomService;

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('perm:two')")
    public String saveHotel(Model model) {
        Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("person", person);
        model.addAttribute("hotel", new Hotel());
        return "create-hotel";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('perm:two')")
    public String saveHotel(@Valid @ModelAttribute("hotel") Hotel hotel,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            model.addAttribute("person", person);
            return "create-hotel";
        }
        if (hotelService.saveHotel(hotel)){
            return "redirect:/home";
        } else {
            String message = "Hotel already exist";
            model.addAttribute("message", message);
            return "create-hotel";
        }
    }

    @GetMapping("/allhotels")
    public String allHotels(Model model){
        model.addAttribute("hotels", hotelService.allHotels());
        return "all-hotels";
    }

    @GetMapping("/searchHotel")
    public String searchHotel(@RequestParam("country") String country, Model model) {
        List<Hotel> searchHotel = hotelService.searchHotelByCountryOrCity(country);
        model.addAttribute("searchHotel", searchHotel);
        return "all-hotels";
    }

    @GetMapping("/deleteHotel/{hotel_id}")
    @PreAuthorize("hasAuthority('perm:two')")
    public String deleteHotel(@PathVariable("hotel_id") long hotelId){
        hotelService.deleteHotel(hotelId);
        return "redirect:/hotels/allhotels-manager";
    }

    @GetMapping("/allhotels-manager")
    @PreAuthorize("hasAuthority('perm:two')")
    public String allHotelsManager(Model model){
        model.addAttribute("hotels", hotelService.allHotels());
        return "all-hotels-manager";
    }

    @GetMapping("/dates")
    public String changedate(Model model){
        Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("person", person);
        return "dates";
    }

    @GetMapping("/available")
    public String getAvailableRooms(@RequestParam("checkin")
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkin,
                                    @RequestParam ("checkout")
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkout,
                                    Model model) {
        Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("person", person);
        model.addAttribute("available", roomService.getAvailableRooms(checkin, checkout));
        model.addAttribute("checkin", checkin);
        model.addAttribute("checkout", checkout);
        return "available";
    }
}
