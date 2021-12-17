package com.example.demo.controller;

import com.example.demo.entite.Person;
import com.example.demo.entite.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/tables")
    public String gettables(Model model){
        List<Person> personsList  = personRepository.findAll();
        model.addAttribute("persons",personsList);
        return"tables";
    }

    @GetMapping("/sup")
    public String sup(@RequestParam("id") Integer id ){
        personRepository.deleteById(id);
        return"redirect:/tables";
    }
  
}
 