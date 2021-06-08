package com.ta.controller;
import com.ta.models.Hotel;
import com.ta.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/create")
    public String saveHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "create-hotel";
    }

    @PostMapping("/create")
    public String saveHotel(@Valid @ModelAttribute("hotel") Hotel hotel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-hotel";
        } else {
            hotelService.saveHotel(hotel);
            return "redirect:/home";
        }
    }

    @GetMapping("/allhotels")
    public String allHotels(Model model){
        model.addAttribute("hotels", hotelService.allHotels());
        return "all-hotels";
    }

    @GetMapping("/searchHotel")
    public String searchHotel(@RequestParam("country") String country, Model model) {
        List<Hotel> searchHotel = hotelService.searchHotelByCountry(country);
        model.addAttribute("searchHotel", searchHotel);
        return "all-hotels";
    }

    @GetMapping("/deleteHotel/{hotel_id}")
    public String deleteHotel(@PathVariable("hotel_id") long hotelId){
        hotelService.deleteHotel(hotelId);
        return "redirect:/hotels/allhotels";
    }
}
