package com.ta.controller;
import com.ta.models.Person;
import com.ta.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;


@Controller
@AllArgsConstructor
public class ManagerController {

    private final PersonService personService;

    @GetMapping("/sent")
    @PreAuthorize("hasAuthority('perm:two')")
    public String manager(Model model){
        String info = SecurityContextHolder.getContext().getAuthentication().getName();
        Collection<? extends GrantedAuthority> info2 = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("info2", info2);
        model.addAttribute("info", info);
        Person person = personService.getPersonByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("person", person);
        return "manager";
    }
}
