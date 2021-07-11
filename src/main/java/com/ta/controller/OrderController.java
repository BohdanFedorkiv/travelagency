package com.ta.controller;
import com.ta.models.Order;
import com.ta.models.Person;
import com.ta.models.Room;
import com.ta.service.OrderService;
import com.ta.service.PersonService;
import com.ta.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;


@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final RoomService roomService;
    private final PersonService personService;

    @GetMapping("/create/{room_id}")
    public String saveOrder(@PathVariable("room_id") int room_id, Model model){
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("room_id", roomService.getRoomById(room_id));
        model.addAttribute("order", new Order());
        model.addAttribute("persons", personService.getAllPersons());
        return "create-order";
    }

    @PostMapping("/create/{room_id}")
    public String saveOrder(Model model,
                            //@RequestParam long person_id,
                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkin,
                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkout,
                            @PathVariable ("room_id") int room_id) {
        Room room = roomService.getRoomById(room_id);
        Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Order order = Order.builder()
                .room(room)
                .checkin(checkin)
                .checkout(checkout)
                .person(person)
                .build();
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("room_id", roomService.getRoomById(room_id));
        model.addAttribute("order", new Order());
        orderService.saveOrder(order);
        return "redirect:/home";
    }

    @GetMapping("/allorders/{person_id}")
    public String allOrders(@PathVariable("person_id") Long person_id, Model model){
        model.addAttribute("orders", orderService.getOrderByUserId(person_id));
        return "allOrders";
    }

    @GetMapping("/delete/{order_id}")
    public String deleteOrder(@PathVariable("order_id") long orderId){
        orderService.deleteOrder(orderId);
        Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        long id = person.getId();
        return "redirect:/orders/allorders/" + id;
    }
}
