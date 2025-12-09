package com.example.userManager.model.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

//Non Utilizzo @Data per evitare problemi con l'ereditarietà
@MappedSuperclass
@Getter
@Setter
public abstract class User
{

  private String name;
  private String email;
  private String role;

  public User()
  {

  }

  public User(String name, String email, String role)
  {
    this.name = name;
    this.email = email;
  }

}