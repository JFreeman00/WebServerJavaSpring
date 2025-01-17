package com.example.WebServer.SmartHome.Entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Class that store the user in the database with the values.
 *
 * @author Jakob Friman Blomdahl
 */

@Entity(name = "users")
@Table
public class Users {


    //CREATE SEQUENCE users_sequence
    //START WITH 1
    //INCREMENT BY 1;

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
    private String password;
    private String email;

    public Users(Long id, String firstName, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;

    }

    public Users(String firstName, String lastName, String password, String email, LocalDate dob) {
        this.firstName = firstName;
        this.password = password;
        this.email = email;
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

    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    //---------Setters------------
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}



