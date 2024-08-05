package com.example.WebServer.SmartHome.Entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

// Class that will store new users in the database

@Entity(name = "users")
@Table
public class Users {

    /*
    CREATE SEQUENCE users_sequence
    START WITH 1
    INCREMENT BY 1;
     */
    // To define a new Key for every user
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    private Long id; // Primary Key
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDate dob;

    @Transient
    private Integer age;


    public Users(Long id, String firstName, String lastName, String password, String email, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    public Users(String firstName, String lastName, String password, String email, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    public Users() {

    }

    //--------Getters----------
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears(); // För att räkna ut åldern
    }

    //---------Setters------------
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
