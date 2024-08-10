package com.example.WebServer.SmartHome.Controller;

//import com.example.WebServer.SmartHome.Entity.Users;
//import com.example.WebServer.SmartHome.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for Users
 */
/*
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    //private UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users users){

        System.out.println(users.getFirstName());
        System.out.println(users.getLastName());
        System.out.println(users.getPassword());
        System.out.println(users.getEmail());
        System.out.println(users.getAge());

        if(usersService.emailValidator(users.getEmail())){
            usersService.addNewUser(users);
            return new ResponseEntity<>("User registers successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Wrong format", HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/all_users")
    public List<Users> getUsers() {
        return usersService.getUsers();
    }
}

 */
