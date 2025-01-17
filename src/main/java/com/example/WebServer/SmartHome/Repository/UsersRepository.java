
package com.example.WebServer.SmartHome.Repository;

import com.example.WebServer.SmartHome.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for the database. Data access layer
 * Used for database
 * @author Jakob Friman Blomdah
 */

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    // users == Users
    @Query("SELECT u FROM users u WHERE u.email = ?1")
    Optional<Users> findUsersByEmail(String email);

}


