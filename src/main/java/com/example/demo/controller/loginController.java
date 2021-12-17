package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {
	
	@GetMapping("/login")
    public String getindex() {
        return "login";
    }
	
	
	@GetMapping("/save2")
    public String save(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.err.println(username);
        System.err.println(password);
		
        return "login";
    }  
}
       