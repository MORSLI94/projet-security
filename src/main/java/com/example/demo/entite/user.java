package com.example.demo.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class user {
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 private String username;
	 private String password;
	 
}

