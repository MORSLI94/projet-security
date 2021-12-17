package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entite.Person;
import com.example.demo.entite.PersonRepository;

@Controller
public class AppController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/signin")
    public String getSignin() {
        return "sign-in";
    }


    @GetMapping("/dash")
    public String getdash() {
        return "dashboard";
    }

    @GetMapping("/save")
    public String save(@RequestParam("nom") String nom,
                       @RequestParam("prenom") String prenom,
                       @RequestParam("matricule") String matricule,
                       @RequestParam("unite") String unite,
                       @RequestParam("grade") String grade){

        System.err.println(nom);
        System.err.println(prenom);
        System.err.println(matricule);
        System.err.println(unite);
        System.err.println(grade);
        Person p = new Person();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setMatricule(matricule);
        p.setUnite(unite);
        p.setGrade(grade);

        //save
        personRepository.save(p);
        return "redirect:/tables";
    }
 
}
