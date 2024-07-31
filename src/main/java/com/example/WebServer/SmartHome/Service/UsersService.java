package com.example.WebServer.SmartHome.Service;

import com.example.WebServer.SmartHome.Entity.Users;
import com.example.WebServer.SmartHome.Repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Class that handles the logic for all Users
 */

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    // För att emailen ska vara i rätt foramt
    private static String EMAIl_CHARS = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static Pattern EMAIL_Patterns = Pattern.compile(EMAIl_CHARS);

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // Returns the list of all users
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    // Static för att vi inte ska behöva skapa en instans av den för testing
    public static boolean emailValidator(String email){
        if(email == null){
            return false;
        }
        return EMAIL_Patterns.matcher(email).matches();
    }

    // Adding a new user
    public void addNewUser(Users users){

        Optional<Users> usersOptional = usersRepository.findUsersByEmail(users.getEmail());

        if(usersOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }

        usersRepository.save(users);
        System.out.println(users);


    }
}
