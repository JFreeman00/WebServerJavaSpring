package com.example.WebServer.SmartHome.Config;

import com.example.WebServer.SmartHome.Entity.Users;
import com.example.WebServer.SmartHome.Repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UsersRepository usersRepository){
        return args -> {
            // Detta är hur vi ska spara våran användare
            Users jake = new Users(
                    "Jake",
                    "Friman",
                    "Hej123",
                    "jake@gmail.se",
                    LocalDate.of(2000, Month.AUGUST, 13)

            );

            Users maja = new Users(
                    "Majs",
                    "Holst",
                    "Jeh123",
                    "Majs@gmail.se",
                    LocalDate.of(2001, Month.JULY, 20)

            );

            usersRepository.saveAll( // För att spara till databasen
                    List.of(jake, maja)
            );
        };
    }
}
