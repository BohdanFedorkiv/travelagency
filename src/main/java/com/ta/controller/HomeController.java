package com.ta.controller;
import com.ta.models.Room;
import com.ta.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Controller
//@RequestMapping("/welcome")
public class HomeController {

    @GetMapping("/home")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "home";
    }
}