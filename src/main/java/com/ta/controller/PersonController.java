package com.ta.controller;
import com.ta.models.Person;
import com.ta.models.Status;
import com.ta.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;


@Controller
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('perm:two')")
    public String getAll(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "persons-list";
    }

    @GetMapping("/create")
    public String personCreate(Model model){
        model.addAttribute("person", new Person());
        return "create-person";
    }

    @PostMapping("/create")
    public String personCreate(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            //model.addAttribute("person", new Person());
            return "create-person";
        }
        person.setStatus(Status.ACTIVE);
        if(!personService.savePerson(person)) {
            return  "create-person";
        }
        return "redirect:/home";
    }
}
