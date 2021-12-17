package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class userController {
		@GetMapping("/user")
	    public String getuser() {
	        return "user";
	        }
	        @GetMapping("/sauver")
		    public String sauver(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role) {
				System.err.println(username);
		        System.err.println(password);
		        System.err.println(role);
				
		        return "user";
		    }
		}
	      
		
		
		
	     
  

