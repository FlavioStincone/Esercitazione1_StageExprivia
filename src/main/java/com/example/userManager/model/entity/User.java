package com.example.userManager.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    private String email;

    // //Costruttore Vuoto
    // public User() {
    // }

    // //Costruttore Pieno
    // public User(int id, String name, String email)
    // {
    //     this.id = id;
    //     this.name = name;
    //     this.email = email;
    // }

    // //Getters and Setters
    // public int getId() {
    //     return id; 
    // }

    // public void setId(int id) {
    //     this.id = id; 
    // }

    // public String getName() {
    //     return name; 
    // }

    // public void setName(String name) {
    //     this.name = name; 
    // }

    // public String getEmail() {
    //     return email; 
    // }
    // public void setEmail(String email) {
    //     this.email = email; 
    // }
}
