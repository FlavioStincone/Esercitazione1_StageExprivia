package com.example.userManager.model.entity;

import javax.management.relation.Role;

import com.example.userManager.model.Base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

//Non Utilizzo @Data per evitare problemi con l'ereditarietà
Ecco l’esercitazione aggiornata con il modello semplificato, senza `BaseEntity`, senza campi aggiuntivi, e con l’uso di record per i DTO.

---

# 🧩 Esercitazione Spring Boot — Gestione Client e Employee con User astratto e DTO record

---

## 1. Creazione progetto

* Usa Spring Initializr ([https://start.spring.io](https://start.spring.io))
* Configura:

  * Maven, Java 21, Spring Boot 3.3.x
  * Dipendenze: Spring Web, Spring Data JPA, Lombok
* Scarica e apri nel tuo IDE

---

## 2. Configura SQLite

* Aggiungi nel `pom.xml`:

```xml
<dependency>
  <groupId>org.xerial</groupId>
  <artifactId>sqlite-jdbc</artifactId>
  <version>3.42.0.0</version>
</dependency>
```

* In `src/main/resources/application.properties` aggiungi:

```properties
spring.datasource.url=jdbc:sqlite:database.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.SQLiteDialect
```

*(Se manca il dialect ufficiale per SQLite usa un dialect generico.)*

---

## 3. Struttura package

```
model/
 ├── Role.java
 ├── User.java
 ├── Client.java
 └── Employee.java

dto/
 ├── ClientDTO.java
 └── EmployeeDTO.java

repository/
 ├── ClientRepository.java
 └── EmployeeRepository.java

service/
 ├── ClientService.java
 └── EmployeeService.java

controller/
 ├── ClientController.java
 └── EmployeeController.java

mapper/
 ├── ClientMapper.java
 └── EmployeeMapper.java
```

---

## 4. Modello entità

* `Role.java`

  * enum con valori: `CLIENT`, `EMPLOYEE`

* `User.java` (classe astratta)

  * `@MappedSuperclass`
  * campi:

    * `@Id @GeneratedValue Long id`
    * `String name`
    * `String email`
    * `Role role` (annotato `@Enumerated(EnumType.STRING)`)

* `Client.java` e `Employee.java`

  * `@Entity` concrete
  * estendono `User`
  * nessun campo aggiuntivo

---

## 5. DTO record

* `ClientDTO.java` e `EmployeeDTO.java` definiti come record con:

```java
public record ClientDTO(Long id, String name, String email, Role role) {}
public record EmployeeDTO(Long id, String name, String email, Role role) {}
```

---

## 6. Mapper (MapStruct)

* `ClientMapper` e `EmployeeMapper` annotati con `@Mapper(componentModel = "spring")`
* Mappano entità ↔ DTO

---

## 7. Repository

* `ClientRepository` e `EmployeeRepository` estendono `JpaRepository<EntityClass, Long>`

---

## 8. Service

* Implementa metodi CRUD per Client e Employee
* Nel metodo di creazione assegna il ruolo corretto (`Role.CLIENT` o `Role.EMPLOYEE`)

---

## 9. Controller REST

* Crea controller per Client e Employee
* Esponi API CRUD usando DTO record in input/output
* Mappa le chiamate ai service

---

## 10. Avvio e test

* Avvia con:

```bash
mvn spring-boot:run
```

* Usa Postman o curl per testare le API:

### Esempio POST Client

```json
{
  "name": "Mario Rossi",
  "email": "mario.rossi@example.com"
}
```

### Esempio POST Employee

```json
{
  "name": "Laura Bianchi",
  "email": "laura.bianchi@example.com"
}
```

---

## 11. Obiettivi didattici

* Gestione entità JPA con classe astratta
* Uso di enum per tipi di utente
* Utilizzo di record Java per DTO immutabili
* MapStruct per mappature efficienti
* Configurazione e uso SQLite in Spring Boot
* Implementazione completa di CRUD REST

---

Se vuoi, posso prepararti una checklist di comandi o uno schema per il workflow di sviluppo. Vuoi?



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
