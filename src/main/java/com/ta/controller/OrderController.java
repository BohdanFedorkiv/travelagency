package com.ta.controller;
import com.ta.models.Hotel;
import com.ta.models.Order;
import com.ta.models.Room;
import com.ta.service.OrderService;
import com.ta.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;


@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final RoomService roomService;

    @GetMapping("/create")
    public String saveOrder(Model model){
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("order", new Order());
        return "create-order";
    }

    @PostMapping("/create")
    public String saveOrder(Model model,
                            @RequestParam int room_id,
                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkin,
                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkout
                            ) {
        Room room = roomService.getRoomById(room_id);
        Order order = Order.builder()
                .room(room)
                .checkin(checkin)
                .checkout(checkout)
                .build();
//        model.addAttribute("localDate", LocalDate.now());
//        model.addAttribute("rooms", roomService.getAllRooms());
//        model.addAttribute("order", order);
        orderService.saveOrder(order);
        return "redirect:/home";
    }

}
