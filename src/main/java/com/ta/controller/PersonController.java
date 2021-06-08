package com.ta.controller;
import com.ta.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "persons-list";
    }
}
