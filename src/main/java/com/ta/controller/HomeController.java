package com.ta.controller;
import com.ta.models.Person;
import com.ta.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;


@Controller
@AllArgsConstructor
public class HomeController {
    private final PersonService personService;

    @GetMapping("/home")
    public String home(Model model) {
        String info = SecurityContextHolder.getContext().getAuthentication().getName();
        Collection<? extends GrantedAuthority> info2 = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("info2", info2);
        model.addAttribute("info", info);
        Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("person", person);
        return "home";
    }
}